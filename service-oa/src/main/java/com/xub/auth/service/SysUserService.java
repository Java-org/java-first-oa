package com.xub.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xub.model.system.SysUser;

import java.util.Map;

public interface SysUserService extends IService<SysUser> {

    void updateStatus(Long id, Integer status);

    /**
     * 根据用户名称获取用户对象
     * @param username
     * @return
     */
    SysUser getByUsername(String username);

    /**
     * 根据用户名获取用户登录信息
     * @param username
     * @return
     */
    Map<String, Object> getUserInfo(String username);
}
