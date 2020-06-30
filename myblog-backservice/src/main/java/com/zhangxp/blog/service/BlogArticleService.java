package com.zhangxp.blog.service;

import com.zhangxp.blog.entity.BlogArticle;
import com.zhangxp.blog.mapper.BlogArticleMapper;
import com.zhangxp.blog.mapper.BlogUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2020/6/27 0027.
 * 博文操作相关
 */
@Service
public class BlogArticleService {

    @Autowired
    private BlogArticleMapper blogArticleMapper;

    public boolean insertArticle(BlogArticle blogArticle) {
        if (blogArticle == null)
        {
            return false;
        }
        return blogArticleMapper.insertSelective(blogArticle) > 0 ? true : false;
    }

    public BlogArticle getArticle() {
        BlogArticle blogArticleDTO = new BlogArticle();
        blogArticleDTO.setId(22);
        BlogArticle blogArticle = blogArticleMapper.selectByPrimaryKey(blogArticleDTO);
        return blogArticle;
    }
}
