package com.xub.auth.controller;

import com.xub.auth.service.SysMenuService;
import com.xub.auth.service.SysUserService;
import com.xub.common.exception.GuiguException;
import com.xub.common.jwt.JwtHelper;
import com.xub.common.result.Result;
import com.xub.common.utils.MD5;
import com.xub.model.system.SysUser;
import com.xub.vo.system.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 后台管理，登录登出
 */
@Api(tags = "后台登录管理")
@RestController
@RequestMapping("/admin/system/index")
public class IndexController {

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysMenuService sysMenuService;

    /**
     * 登录
     * @return
     */
    @ApiOperation(value = "login")
    @PostMapping("login")
    public Result login(@RequestBody LoginVo loginVo ) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("token","admin");
//        return Result.ok(map);
        SysUser sysUser = sysUserService.getByUsername(loginVo.getUsername());
        if(null == sysUser) {
            throw new GuiguException(201,"用户不存在");
        }
        if(!MD5.encrypt(loginVo.getPassword()).equals(sysUser.getPassword())) {
            throw new GuiguException(201,"密码错误");
        }
        if(sysUser.getStatus().intValue() == 0) {
            throw new GuiguException(201,"用户被禁用");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("token", JwtHelper.createToken(sysUser.getId(), sysUser.getUsername()));
        return Result.ok(map);

    }

    /**
     * 获取用户信息
     * @return
     * 1 从请求头获取用户信息（获取请求头 token 字符串）
     * 2 从 token 字符串获取用户 id
     * 3 根据用户id查询数据库，把用户信息获取出来
     * 4 根据用户id获取用户可以操作的菜单列表，构建动态路由
     * 5 根据用户id获取用户可以操作的按钮列表
     */
    @GetMapping("info")
    public Result info(HttpServletRequest request) {
        //从请求头获取用户信登录请求的username
        String username = JwtHelper.getUsername(request.getHeader("token"));
//        String username = "admin";  用于测试，避免传入请求头
        Map<String, Object> map = sysUserService.getUserInfo(username);
        return Result.ok(map);
    }

    /**
     * 退出
     * @return
     */
    @PostMapping("logout")
    public Result logout(){
        return Result.ok();
    }
}
