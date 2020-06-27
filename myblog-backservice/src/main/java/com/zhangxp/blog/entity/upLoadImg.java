package com.zhangxp.blog.entity;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;

/**
 * Created by Administrator on 2020/6/27 0027.
 */
@Entity
public class upLoadImg {
    private String pos;
    private MultipartFile multipartFile;

    public void setPos(String pos) { this.pos = pos;}
    public void setMultipartFile(MultipartFile multipartFile) {this.multipartFile = multipartFile;}
    public String getPos() {return this.pos;}
    public MultipartFile getMultipartFile() {return this.multipartFile;}
}
