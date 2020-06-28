package com.zhangxp.blog.security.service;

import com.zhangxp.blog.entity.BlogUser;
import com.zhangxp.blog.mapper.BlogUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by zhangxp on 2020/6/28.
 * 通过实现UserDetailsService的loadUserByUsername接口,构建用户信息
 */
@Service
public class MyUserDetailsService implements UserDetailsService{
    @Autowired
    private BlogUserMapper userMapper;

    @Override
    public  UserDetails loadUserByUsername(String val1) throws UsernameNotFoundException {
        System.out.println("-----------loadUserByUsername---------- name:" + val1);

        BlogUser blogUserDTO = new BlogUser();
        blogUserDTO.setUserName(val1);
        BlogUser blogUser = userMapper.selectOne(blogUserDTO);
        if (blogUser == null)
        {
            System.out.println("----------------blogUser is null----------");
            return null;
        }
        System.out.println(blogUser.toString());
        UserDetails userDetails = User.withUsername(blogUser.getUserName()).password(blogUser.getPassword()).authorities("p1").build();
        return userDetails;
    }
}
