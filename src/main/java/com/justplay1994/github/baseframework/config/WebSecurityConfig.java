package com.justplay1994.github.baseframework.config;

import com.justplay1994.github.baseframework.service.impl.AuthenticationServiceImpl;
import com.justplay1994.github.baseframework.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * @Package: com.justplay1994.github.baseframework.config
 * @Project: base-framework
 * @Description: //TODO
 * @Creator: huangzezhou
 * @Create_Date: 2018/10/22 10:47
 * @Updater: huangzezhou
 * @Update_Date: 2018/10/22 10:47
 * @Update_Description: huangzezhou 补充
 **/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin").password("123456").roles("USER");
//    }

    @Autowired
    UserServiceImpl userService;

    @Autowired
    AuthenticationServiceImpl authenticationService;

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
//            }
//
//            /**
//             * @param charSequence 明文
//             * @param s 密文
//             * @return
//             */
//            @Override
//            public boolean matches(CharSequence charSequence, String s) {
//                return s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
//            }
//        });
//    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable()//关闭csrf
//                .formLogin()
//                .loginPage("/login")
//                .defaultSuccessUrl("/index")
//                .permitAll()
                .httpBasic()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截的问题
        web.ignoring().antMatchers("/css/**");
        //swagger调试，开放权限
        web.ignoring().antMatchers("/swagger-ui.html");
        web.ignoring().antMatchers("/v2/api-docs");
        web.ignoring().antMatchers("/webjars/**");
        web.ignoring().antMatchers("/swagger-resources/**");

        //自定义登录接口
        web.ignoring().antMatchers("/tokenLogin");
//        web.ignoring().antMatchers("/**");
    }
}
