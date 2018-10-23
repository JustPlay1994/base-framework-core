package com.justplay1994.github.baseframework.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Package: com.justplay1994.github.baseframework.service.impl
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 11:49
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 11:49
 * @Update_Description: huangzezhou 补充
 **/

@Service
public class AuthenticationServiceImpl implements AuthenticationProvider{

    @Autowired
    UserServiceImpl userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        String username = token.getName();
        //从数据库找到的用户
        UserDetails userDetails = null;
        if(username != null) {
            userDetails = userService.loadUserByUsername(username);
        }
        //
        if(userDetails == null) {
            throw new UsernameNotFoundException("用户名/密码无效");
        }else if (!userDetails.isEnabled()){
            throw new DisabledException("用户已被禁用");
        }else if (!userDetails.isAccountNonExpired()) {
            throw new AccountExpiredException("账号已过期");
        }else if (!userDetails.isAccountNonLocked()) {
            throw new LockedException("账号已被锁定");
        }else if (!userDetails.isCredentialsNonExpired()) {
            throw new LockedException("凭证已过期");
        }
        //数据库用户的密码
        String password = userDetails.getPassword();
        //与authentication里面的credentials相比较
        if(!password.equals(token.getCredentials())) {
            throw new BadCredentialsException("Invalid username/password");
        }
        //授权
        return new UsernamePasswordAuthenticationToken(userDetails, password,userDetails.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
