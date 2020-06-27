//package com.zhangxp.blog.config;
//
//import org.springframework.security.web.authentication.WebAuthenticationDetails;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by Administrator on 2020/6/25 0025.
// */
//public class MyWebAuthenticationDetails extends WebAuthenticationDetails {
//    private static final long serialVersionUID = 6975601077710753878L;
//
//    private String username;
//
//    private String password;
//
//    private String validcode;
//
//    private String sessionCodeValue;
//
//    private long sessionCodeTime;
//
//    public String getSessionCodeValue() {
//        return sessionCodeValue;
//    }
//
//    public void setSessionCodeValue(String sessionCodeValue) {
//        this.sessionCodeValue = sessionCodeValue;
//    }
//
//    public long getSessionCodeTime() {
//        return sessionCodeTime;
//    }
//
//    public void setSessionCodeTime(long sessionCodeTime) {
//        this.sessionCodeTime = sessionCodeTime;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getValidcode() {
//        return validcode;
//    }
//
//    public void setValidcode(String validcode) {
//        this.validcode = validcode;
//    }
//
//    @Override
//    public String toString() {
//        return "AuthenticationDetails: username" + this.username + "password: " + this.password +
//                "sessionCodeValue: " + this.sessionCodeValue + "sessionCodeTime: " + this.sessionCodeTime
//                + "validcode: " + this.validcode;
//    }
//
//    public MyWebAuthenticationDetails(HttpServletRequest request) {
//        super(request);
//        System.out.println("--------------MyWebAuthenticaitonDetails-------------");
//        username = request.getParameter("username");
//        password = request.getParameter("password");
//        System.out.println("uername: "+username + "password: " + password);
////        validcode = request.getParameter("validateCode");
////        sessionCodeValue = (String)request.getSession().getAttribute("codeValue");
////        sessionCodeTime = (Long)request.getSession().getAttribute("codeTime");
////        System.out.println("sessionCodeValue: " + sessionCodeValue + "sessionCodeTime: " + sessionCodeTime);
//    }
//}
