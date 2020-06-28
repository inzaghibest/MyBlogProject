package com.zhangxp.blog.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
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
    @PostMapping(value = "/articles/add/imgUpLoad")
    public ArrayList<String> fileUpload(@RequestParam("files") MultipartFile[] multipartFiles) {
        System.out.print("---------" + multipartFiles.length + "---------");
        if (multipartFiles.length == 0)
        {
            System.out.print("error 0");
        }
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0;  i<multipartFiles.length; i++)
        {
            MultipartFile file = multipartFiles[i];
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            String filePath = "M:\\temp-rainy\\"; // 上传后的路径
            fileName = UUID.randomUUID() + suffixName; // 新文件名
            File dest = new File(filePath + fileName);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String filename = "M:\\temp-rainy\\" + fileName;
            list.add(filename);
        }
        return list;
    }
}
