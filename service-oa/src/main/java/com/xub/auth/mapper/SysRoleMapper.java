package com.xub.auth.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xub.model.system.SysRole;
import org.apache.ibatis.annotations.Mapper;

import javax.annotation.Resource;

/**
 * 1.注意 BaseMapper 中的泛型
 * 2.IDEA在sysRoleMapper处报错，因为找不到注入的对象，因为类是动态创建的，但是程序可以正确的执行。为了避免报错，可以在 mapper 层 的接口上添加 @4或直接使用 @Resource 代替 @Autowired
 *
 * com.baomidou.mybatisplus.core.mapper.BaseMapper这是Mybatis-Plus提供的默认Mapper接口
 */
@Mapper
@Resource
public interface SysRoleMapper extends BaseMapper<SysRole> {

}
