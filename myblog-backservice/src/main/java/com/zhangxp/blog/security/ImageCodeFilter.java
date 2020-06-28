package com.zhangxp.blog.security;

import com.zhangxp.blog.security.authentication.MyAuthenticationFailureHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * Created by zhangxp on 2020/6/28.
 * 自定义验证码过滤器, OncePerRequestFilter保证过滤器只调用一次
 */
//@Component
//public class ImageCodeFilter extends OncePerRequestFilter {
//    @Autowired
//    private MyAuthenticationFailureHandler authenticationFailureHandler;
//
//
//
//}
