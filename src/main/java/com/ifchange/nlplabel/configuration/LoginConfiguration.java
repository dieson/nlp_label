package com.ifchange.nlplabel.configuration;

import com.ifchange.nlplabel.interceptor.LoginHandlerIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: LoginConfiguration
 * @Description: 登录拦截器配置
 * @author: Dieson Zuo
 * @date: Created in 12:17 2018/11/15
 */

@Configuration
public class LoginConfiguration implements WebMvcConfigurer {

    @Autowired
    private LoginHandlerIntercepter loginInterceptor;

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/account/login");
    }
}
