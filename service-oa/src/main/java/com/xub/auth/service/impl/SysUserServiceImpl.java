package com.xub.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xub.auth.mapper.SysUserMapper;
import com.xub.auth.service.SysUserService;
import com.xub.model.system.SysUser;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

}
