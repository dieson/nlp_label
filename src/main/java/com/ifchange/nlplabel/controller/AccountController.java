package com.ifchange.nlplabel.controller;

import com.ifchange.nlplabel.constant.Const;
import com.ifchange.nlplabel.constant.ResponseCode;
import com.ifchange.nlplabel.dto.ServerResponse;
import com.ifchange.nlplabel.entity.Account;
import com.ifchange.nlplabel.service.IAccountService;
import com.ifchange.nlplabel.util.ValidataUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @ClassName: AccountController
 * @Description: 用户
 * @author: Dieson Zuo
 * @date: Created in 19:19 2018/11/20
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IAccountService iAccountService;

    /**
     * 注册账号，暂不实现
     * @param uname
     * @param pw
     * @param pw2
     */
    public void accountReg(String uname, String pw, String pw2) {}

    /**
     * 编辑账号，暂不实现
     */
    public void accountEdit() {}

    /**
     * 账号权限，暂不实现
     */
    public void accountType(){}

    /**
     * 登录
     * @param account
     * @param result
     * @param session
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ServerResponse accountLogin(@Validated @RequestBody Account account, BindingResult result, HttpSession session) {
        logger.info("登录");

        String dataResult = ValidataUtil.judgeValidata(result);
        if (!dataResult.equals(ResponseCode.PARAM_CORRECT.getDesc())) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.PARAM_INCORRECT.getCode(), ResponseCode.PARAM_INCORRECT.getDesc(), dataResult);
        }

        if (iAccountService.login(account.getUsername(), account.getPassword())) {
            session.setAttribute(Const.CURRENT_USER, account);
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS);
        } else {
            return ServerResponse.createByErrorMesssage(ResponseCode.ERROR.getDesc());
        }
    }

    @RequestMapping(value = "/logout")
    public ServerResponse logout(HttpSession session) {
        logger.info("登出");

        session.removeAttribute(Const.CURRENT_USER);
        if (session.getAttribute(Const.CURRENT_USER) == null) {
            return ServerResponse.createBySuccess(ResponseCode.SUCCESS);
        } else {
            return ServerResponse.createByErrorMesssage(ResponseCode.ERROR.getDesc());
        }
    }

    @RequestMapping(value = "/hello")
    public String hello() {
        return "hello";
    }
}
