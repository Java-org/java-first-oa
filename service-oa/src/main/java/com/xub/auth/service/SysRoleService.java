package com.xub.auth.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xub.model.system.SysRole;
import com.xub.vo.system.AssginRoleVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * com.baomidou.mybatisplus.extension.service.IService这是Mybatis-Plus提供的默认Service接口
 */

public interface SysRoleService extends IService<SysRole> {
    /**
     * 根据用户获取角色数据
     * @param userId
     * @return
     */
    Map<String, Object> findRoleByAdminId(Long userId);

    /**
     * 分配角色
     * @param assginRoleVo
     */
    void doAssign(AssginRoleVo assginRoleVo);
}
