//package com.zhangxp.blog.service;
//
//import com.zhangxp.blog.entity.BlogUser;
//import com.zhangxp.blog.mapper.BlogUserMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * Created by Administrator on 2020/6/25 0025.
// */
//@Service
//public class MyUserDetailsService implements UserDetailsService{
//    @Autowired
//    private BlogUserMapper blogUserMapper;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        BlogUser UserDTO = new BlogUser();
//        UserDTO.setUserName(username);
//        BlogUser myUser =  blogUserMapper.selectOne(UserDTO);
//        if (myUser == null)
//        {
//            return null;
//        }
//        UserDetails userDetails = User.withUsername(myUser.getUserName()).password(myUser.getPassword()).build();
//        return userDetails;
//    }
//
//}
