package com.ifchange.nlplabel.service.impl;

import com.ifchange.nlplabel.dao.AccountRepository;
import com.ifchange.nlplabel.entity.Account;
import com.ifchange.nlplabel.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: AccountServiceImpl
 * @Description:
 * @author: Dieson Zuo
 * @date: Created in 19:53 2018/11/20
 */
@Service("iAccountService")
public class AccountServiceImpl implements IAccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public boolean login(String username, String password) {
        Account account = accountRepository.findByUnameAndPassword(username, password);
        return account != null;
    }
}
