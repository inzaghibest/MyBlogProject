package com.zhangxp.blog.controller;

import com.zhangxp.blog.entity.BlogArticle;
import com.zhangxp.blog.entity.BlogUser;
import com.zhangxp.blog.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2020/6/25 0025.
 */
@RestController
public class indexController {
//    @RequestMapping("/login")
//    public String index() {
//        return "sdfsdf s + success";
//    }
    @Autowired
    private BlogArticleService blogArticleService;
    @PostMapping(value = "/login")
    public String handlePostRequest(@RequestBody BlogUser blogUser)
    {
        System.out.println("username " + blogUser.getUserName());
        System.out.println("password" + blogUser.getPassword());
        System.out.print("test");
        return "test";
    }

    @PostMapping(value = "/articles/add")
    public String handleAddArticles(@RequestBody BlogArticle blogArticle)
    {
        System.out.print("------------handleAddArticles------------" + blogArticle.toString());
        blogArticleService.insertArticle(blogArticle);
        return "success";
    }




}
