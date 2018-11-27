package com.ifchange.nlplabel.service.impl;

import com.ifchange.nlplabel.dao.AccountRepository;
import com.ifchange.nlplabel.dao.PermissionRepository;
import com.ifchange.nlplabel.entity.Account;
import com.ifchange.nlplabel.entity.Permission;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CustomUserService
 * @Description: get user details
 * @author: Dieson Zuo
 * @date: Created in 9:32 2018/11/16
 */
@Service
public class CustomUserServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(CustomUserServiceImpl.class);
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Account account = accountRepository.findByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }

        logger.info("loadUserByUsername: " + account);
        List<Permission> permissions = permissionRepository.findByUserId(account.getUid());
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Permission permission : permissions) {
            if (permission != null && permission.getName() != null) {

                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                //1：此处将权限信息添加到 GrantedAuthority 对象中，在后面进行全权限验证时会使用GrantedAuthority 对象。
                grantedAuthorities.add(grantedAuthority);
            }
        }
        account.setGrantedAuthorities(grantedAuthorities);
        return account;

    }
}
