package com.ifchange.nlplabel.configuration;

import com.ifchange.nlplabel.service.impl.CustomUserServiceImpl;
import com.ifchange.nlplabel.service.impl.FilterSecurityInterceptorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

/**
 * @ClassName: WebSecurityConfig
 * @Description: 权限管理
 * @author: Dieson Zuo
 * @date: Created in 16:52 2018/11/15
 */
@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private FilterSecurityInterceptorImpl filterSecurityInterceptorImpl;

    @Autowired
    private CustomUserServiceImpl customUserServiceImpl;

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest().authenticated() //任何请求,登录后可以访问
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll() //登录页面用户任意访问
                .and()
                .logout().permitAll(); //注销行为任意访问
        http.addFilterBefore(filterSecurityInterceptorImpl, FilterSecurityInterceptor.class);
    }
}
