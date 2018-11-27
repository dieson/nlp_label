package com.ifchange.nlplabel.util;

import com.ifchange.nlplabel.constant.ResponseCode;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @ClassName: ValidataUtil
 * @Description: 传参校验
 * @author: Dieson Zuo
 * @date: Created in 10:17 2018/11/15
 */
public class ValidataUtil {

    public static String judgeValidata(BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            StringBuilder stringBuilder = new StringBuilder();
            for (ObjectError error : list) {
                stringBuilder.append(error.getDefaultMessage() + ";");
            }
            return stringBuilder.toString();
        }
        return ResponseCode.PARAM_CORRECT.getDesc();
    }
}
