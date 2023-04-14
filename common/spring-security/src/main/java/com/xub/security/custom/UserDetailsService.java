package com.xub.security.custom;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * 需要继承 spring的 UserDetailsService类，后续 WebSecurityConfig 需要传入 spring的 UserDetailsService对象
 * 定义的接口没有实际意义，主要是规范化开发方式。
 * UserDetailsServiceImpl 类可以直接实现 spring的 UserDetailsService类的接口
 */
@Component
public interface UserDetailsService extends org.springframework.security.core.userdetails.UserDetailsService {

    /**
     * 根据用户名获取用户对象（获取不到直接抛异常）
     */
    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
