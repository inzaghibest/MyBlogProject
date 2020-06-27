//package com.zhangxp.blog.config;
//
//import com.zhangxp.blog.service.MyUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
///**
// * Created by Administrator on 2020/6/25 0025.
// */
//@Component
//public class MyAuthenticaitonProvider implements AuthenticationProvider {
//    @Autowired
//    private MyUserDetailsService userDetailsService;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        MyWebAuthenticationDetails details = (MyWebAuthenticationDetails) authentication.getDetails();
//        if (details != null){
//            System.out.print("test");
//        }
////        System.out.println(details);
//        Collection<GrantedAuthority> auths=new ArrayList<GrantedAuthority>();
//        auths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        return new UsernamePasswordAuthenticationToken(details.getUsername(),details.getPassword(),auths);
//    }
//
//    @Override
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
