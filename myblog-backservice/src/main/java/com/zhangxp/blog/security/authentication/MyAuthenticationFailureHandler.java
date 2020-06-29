package com.zhangxp.blog.security.authentication;

import com.alibaba.fastjson.JSONObject;
import com.zhangxp.blog.common.Result;
import com.zhangxp.blog.common.ResultCode;
import com.zhangxp.blog.common.ResultUtil;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhangxp on 2020/6/28.
 * 失败处理handler
 */
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e)
                                        throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        StringBuffer sb = new StringBuffer();
        Result result = new Result();
        if (e instanceof UsernameNotFoundException || e instanceof BadCredentialsException) {
            result = ResultUtil.error(ResultCode.ERROR, "用户名或密码输入错误，登录失败!");
        } else if (e instanceof DisabledException) {
            result = ResultUtil.error(ResultCode.ERROR, "账户被禁用，登录失败，请联系管理员!");
        } else {
            result = ResultUtil.error(ResultCode.ERROR, "登录失败:" +  "用户不存在!"/*e.fillInStackTrace()*/);
        }
        out.write(JSONObject.toJSONString(result));
        out.flush();
        out.close();
    }
}
