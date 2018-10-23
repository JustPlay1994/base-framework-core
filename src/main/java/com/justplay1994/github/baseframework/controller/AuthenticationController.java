package com.justplay1994.github.baseframework.controller;

import com.justplay1994.github.baseframework.api.AuthenticationApi;
import com.justplay1994.github.baseframework.dao.model.MyUser;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Package: com.justplay1994.github.baseframework.controller
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 11:36
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 11:36
 * @Update_Description: huangzezhou 补充
 **/
@RestController
public class AuthenticationController implements AuthenticationApi {
    @Override
    public String tokenLogin(String username, String password) {
        SecurityContextHolder.setStrategyName("MODE_GLOBAL");

        MyUser myUser = (MyUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(myUser);
        return "自定义登录接口！";
    }
}
