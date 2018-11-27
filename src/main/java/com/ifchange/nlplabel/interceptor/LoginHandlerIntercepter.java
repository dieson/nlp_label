package com.ifchange.nlplabel.interceptor;

import com.alibaba.fastjson.JSON;
import com.ifchange.nlplabel.constant.Const;
import com.ifchange.nlplabel.constant.ResponseCode;
import com.ifchange.nlplabel.dto.ServerResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @ClassName: LoginHandlerIntercepter
 * @Description: 登录拦截器
 * @author: Dieson Zuo
 * @date: Created in 16:06 2018/11/15
 */
@Component
public class LoginHandlerIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Object user = request.getSession().getAttribute(Const.CURRENT_USER);
        if (user == null) {
            PrintWriter out;
            try {
                ServerResponse res = ServerResponse.createByErrorCodeMessage(HttpServletResponse.SC_FORBIDDEN, ResponseCode.LOGIN_FAIL.getDesc());
                out = response.getWriter();
                out.append(JSON.toJSONString(res));
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                response.sendError(HttpServletResponse.SC_BAD_GATEWAY);
                return false;
            }
        }
        return true;

        // 从request中得到token
		/*String token = (String) runTest.getHeader(Const.TOKEN);
		// 验证token
		Token model = iTokenManager.getToken(token);
		if (iTokenManager.checkToken(model)) {
			// 如果token验证成功，将token对应的用户id存在request中，便于之后注入
			runTest.setAttribute(Const.CURRENT_USER_ID, model.getUserId());
			return true;
		} else {
			response.sendRedirect("/green");
			return false;
		}*/

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub

    }

}
