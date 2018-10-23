package com.justplay1994.github.baseframework.service.impl;

import com.justplay1994.github.baseframework.dao.model.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Package: com.justplay1994.github.baseframework.service.impl
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 14:21
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 14:21
 * @Update_Description: huangzezhou 补充
 **/
@Service("userService")
public class UserServiceImpl implements UserDetailsService {

    @Override
    public MyUser loadUserByUsername(String s) throws UsernameNotFoundException {
        //post请求中的 username
        String username = s;
        if (!username.equals("admin"))
            throw new UsernameNotFoundException("该用户不存在");
        return new MyUser("admin","123");
    }
}
