package com.zhangxp.blog.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.zhangxp.blog.common.Result;
import com.zhangxp.blog.common.ResultCode;
import com.zhangxp.blog.entity.BlogArticle;
import com.zhangxp.blog.service.BlogArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

import com.zhangxp.blog.entity.upLoadImg;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Created by Administrator on 2020/6/27 0027.
 * 处理文件上传
 */
@RestController
public class fileUpController {
    @Autowired
    private BlogArticleService blogArticleService;
    // 处理图片上传
    @PostMapping(value = "/articles/add/imgUpLoad")
    public Result fileUpload(@RequestParam("files") MultipartFile[] multipartFiles) {
        System.out.print("---------" + multipartFiles.length + "---------");
        Result result = new Result();
        result.setCode(ResultCode.SUCCESS);

        if (multipartFiles.length == 0)
        {
            result.setMsg("文件为空");
            return result;
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        for (int i = 0;  i<multipartFiles.length; i++)
        {
            MultipartFile file = multipartFiles[i];
            String fileName = file.getOriginalFilename();
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            String filePath = "M:\\temp-rainy\\";
            fileName = UUID.randomUUID() + suffixName;
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                result.setCode(ResultCode.ERROR);
                result.setMsg("创建文件失败!");
                return result;
            }
            String filename = "M:\\temp-rainy\\" + fileName;
            result.setMsg("上传图片成功");
            arrayList.add(filename);
        }
        result.setData(arrayList);
        return result;
    }

    @PostMapping(value = "/articles/add")
    public Result handleAddArticles(@RequestBody BlogArticle blogArticle)
    {
        System.out.print("------------handleAddArticles------------" + blogArticle.toString());
        boolean bSucces = blogArticleService.insertArticle(blogArticle);
        Result result = new Result();
        if (bSucces) {
            result.setCode(ResultCode.SUCCESS);
            result.setMsg("插入文章成功!");
        }else {
            result.setCode(ResultCode.ERROR);
            result.setMsg("插入数据库失败!");
        }
        return result;
    }
}
