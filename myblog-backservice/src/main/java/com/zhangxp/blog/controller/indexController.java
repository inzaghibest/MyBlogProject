package com.zhangxp.blog.controller;

import com.zhangxp.blog.entity.BlogArticle;
import com.zhangxp.blog.entity.BlogUser;
import com.zhangxp.blog.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2020/6/25 0025.
 */
@RestController
public class indexController {
    @RequestMapping("/test")
    public String index() {
        return "sdfsdf s + success";
    }

//    @RequestMapping("/login")
//    @ResponseBody
//    public String login() {
//        return "sdfsdf s + success";
//    }


    @RequestMapping(value = "/login-success")
    @ResponseBody
    public String logSuccess() {
        // 提示用户名称成功
        return getUserName() + "登录成功!";
    }


    @RequestMapping(value = "/r/r1")
    @ResponseBody
    public String r1() {
        return getUserName() + "访问资源r1";
    }

    @RequestMapping(value = "/r/r2")
    @ResponseBody
    public String r2() {
        return getUserName() +  "访问资源r2";
    }


//    @RequestMapping("/")
//    public String index() {
//        return "我是根路径页面!";
//    }

    // 登录成功后，获取登录用户相关信息的方法
    private String getUserName() {
        String username = null;
        Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
        // 用户身份
        Object principal = authentication.getPrincipal();
        if (principal == null)
        {
            username = "匿名";
        }else if (principal instanceof UserDetails)
        {
            UserDetails userDetails = (UserDetails) principal;
            username = userDetails.getUsername();
        }else
        {
            username = principal.toString();
        }
        return username;
    }

    @Autowired
    private BlogArticleService blogArticleService;
//    @PostMapping(value = "/login")
//    public String handlePostRequest(@RequestBody BlogUser blogUser)
//    {
//        System.out.println("username " + blogUser.getUserName());
//        System.out.println("password" + blogUser.getPassword());
//        System.out.print("test");
//        return "test";
//    }

    @PostMapping(value = "/articles/add")
    public String handleAddArticles(@RequestBody BlogArticle blogArticle)
    {
        System.out.print("------------handleAddArticles------------" + blogArticle.toString());
        blogArticleService.insertArticle(blogArticle);
        return "success";
    }




}
