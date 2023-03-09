package com.xub.vo.system;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 角色查询实体类，区别与 SysRole 实体类，用处不同
 */
@Data
public class SysRoleQueryVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleName;

}
