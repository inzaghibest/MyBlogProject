package com.zhangxp.blog.security.authentication;

import com.alibaba.fastjson.JSONObject;
import com.zhangxp.blog.common.Result;
import com.zhangxp.blog.common.ResultCode;
import com.zhangxp.blog.common.ResultUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhangxp on 2020/6/28.
 * 成功处理handler
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        httpServletResponse.setContentType("application/json;charset=utf-8");
        PrintWriter out = httpServletResponse.getWriter();
        Result result = ResultUtil.success(ResultCode.SUCCESS, "登录成功！");
        out.write(JSONObject.toJSONString(result));
        out.flush();
        out.close();
    }
}
