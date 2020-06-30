package com.zhangxp.blog.controller;

import com.zhangxp.blog.common.Result;
import com.zhangxp.blog.common.ResultCode;
import com.zhangxp.blog.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticlesController {
    @Autowired
    private BlogArticleService blogArticleService;
    @RequestMapping("/articles/detail")
    public Result getArticlesDetail() {
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);
        result.setMsg("获取文章成功!");
        result.setData(blogArticleService.getArticle());
        return result;
    }
}
