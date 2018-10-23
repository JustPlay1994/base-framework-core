package com.justplay1994.github.baseframework.dao.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Package: com.justplay1994.github.baseframework.dao.model
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 14:53
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 14:53
 * @Update_Description: huangzezhou 补充
 **/
public class MyUser implements UserDetails {

    String username;
    String password;

    public MyUser(){

    }

    public MyUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * 账号是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账号是否被锁
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 判断用户凭证是否已经过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否有效
     * @return
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
