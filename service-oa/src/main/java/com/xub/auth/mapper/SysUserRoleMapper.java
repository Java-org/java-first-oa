package com.xub.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xub.model.system.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

@Mapper
@Resource
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

}
