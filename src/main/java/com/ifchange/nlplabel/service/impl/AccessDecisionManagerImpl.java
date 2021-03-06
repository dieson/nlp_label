package com.ifchange.nlplabel.service.impl;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName: MyAccessDecisionManager
 * @Description: 判断用户是否拥有权限
 * @author: Dieson Zuo
 * @date: Created in 14:34 2018/11/16
 */
@Service
public class AccessDecisionManagerImpl implements AccessDecisionManager {
    /**
     * 是判定是否拥有权限的决策方法
     *
     * @param authentication 是释CustomUserService中循环添加到 GrantedAuthority 对象中的权限信息集合.
     * @param o              包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
     * @param collection     为MyInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object o, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        if (null == collection || collection.size() <= 0) {
            return;
        }
        for (Iterator<ConfigAttribute> iter = collection.iterator(); iter.hasNext(); ) {
            String needRole = iter.next().getAttribute();
            for (GrantedAuthority ga : authentication.getAuthorities()) {//authentication 为在注释1 中循环添加到 GrantedAuthority 对象中的权限信息集合
                if (needRole.trim().equals(ga.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("no right");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
