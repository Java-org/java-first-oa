package com.xub.vo.system;

import lombok.Data;

/**
 * 用户查询实体
 */
@Data
public class SysUserQueryVo {

    private static final long serialVersionUID = 1L;

    private String keyword;

    private String createTimeBegin;
    private String createTimeEnd;

    private Long roleId;
    private Long postId;
    private Long deptId;
}
