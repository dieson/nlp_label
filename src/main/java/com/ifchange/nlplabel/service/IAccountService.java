package com.ifchange.nlplabel.service;

/**
 * @ClassName: IAccountService
 * @Description: 用户接口
 * @author: Dieson Zuo
 * @date: Created in 19:52 2018/11/20
 */
public interface IAccountService {
    boolean login(String username, String password);
}
