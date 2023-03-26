package com.xub.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xub.model.system.SysMenu;
import com.xub.model.system.SysUser;
import com.xub.vo.system.AssginMenuVo;
import com.xub.vo.system.RouterVo;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;


public interface SysMenuService extends IService<SysMenu> {

    /**
     * 菜单显示图形数据
     * @return
     */
    List<SysMenu> findNodes();

    boolean removeById(Serializable id);

    /**
     * 根据角色获取授权权限数据
     * @return
     */
    List<SysMenu> findSysMenuByRoleId(Long roleId);

    /**
     * 保存角色权限
     * @param  assginMenuVo
     */
    void doAssign(AssginMenuVo assginMenuVo);

    List<RouterVo> findUserMenuList(Long id);

    List<String> findUserPermsList(Long id);

}
