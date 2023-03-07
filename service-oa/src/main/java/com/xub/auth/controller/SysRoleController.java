package com.xub.auth.controller;

import com.xub.auth.service.SysRoleService;
import com.xub.model.system.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 访问时，格式为 http://localhost:8800/admin/system/sysRole/findAll
 */

@RequestMapping("/admin/system/sysRole")
@RestController
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @GetMapping("findAll")
    public List<SysRole> findAll(){
        List<SysRole> roleList = sysRoleService.list();
        return roleList;
    }
}
