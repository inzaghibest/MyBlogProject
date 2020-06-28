package com.zhangxp.blog.security.config;

import com.zhangxp.blog.security.authentication.MyAuthenticationFailureHandler;
import com.zhangxp.blog.security.authentication.MyAuthenticationSuccessHandler;
import com.zhangxp.blog.security.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
//
///**
// * Created by Administrator on 2020/6/25 0025.
// */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
    @Autowired
    private  MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Autowired
    private  MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private  MyUserDetailsService myUserDetailsService;
//    SecurityContextPersistenceFilter
//    @Autowired
//    private MyUserDetailsService myUserDetailsService;

//    @Autowired
//    private AuthenticationDetailsSource<HttpServletRequest, WebAuthenticationDetails> authenticationDetailsSource;
//
//
//    @Autowired
//    private AuthenticationProvider authenticationProvider;
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.authenticationProvider(authenticationProvider);
//    }

//    //定义登陆成功返回信息
//    private class AjaxAuthSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//        @Override
//        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
//            System.out.println("商户[" + SecurityContextHolder.getContext().getAuthentication().getPrincipal() +"]登陆成功！");
//            //登陆成功后移除session中验证码信息
////            request.getSession().removeAttribute("codeValue");
////            request.getSession().removeAttribute("codeTime");
//
//            response.setContentType("application/json;charset=utf-8");
//            PrintWriter out = response.getWriter();
//            out.write("{\"status\":\"ok\",\"msg\":\"登录成功\"}");
//            out.flush();
//            out.close();
//        }
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //定义登陆失败返回信息
//    private class AjaxAuthFailHandler extends SimpleUrlAuthenticationFailureHandler {
//        @Override
//        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//            //登陆失败后移除session中验证码信息
////            request.getSession().removeAttribute("codeValue");
////            request.getSession().removeAttribute("codeTime");
//
//            response.setContentType("application/json;charset=utf-8");
//            response.setStatus(HttpStatus.UNAUTHORIZED.value());
//            PrintWriter out = response.getWriter();
//            out.write("{\"status\":\"error\",\"msg\":\"请检查用户名、密码或验证码是否正确\"}");
//            out.flush();
//            out.close();
//        }
//    }

//    定义异常返回信息
    public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {
        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
            response.sendError(HttpStatus.UNAUTHORIZED.value(),authException.getMessage());
        }

    }

    //定义登出成功返回信息
    private class AjaxLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

        public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                                    Authentication authentication) throws IOException, ServletException {
            response.setContentType("application/json;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("{\"status\":\"ok\",\"msg\":\"登出成功\"}");
            out.flush();
            out.close();
        }
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .exceptionHandling().authenticationEntryPoint(new UnauthorizedEntryPoint())
//                .and()
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/login","/login").permitAll()
//                .anyRequest().authenticated()
//                .and().formLogin().loginPage("/login")
//                .successHandler(new AjaxAuthSuccessHandler())
//                .failureHandler(new AjaxAuthFailHandler())
//                .loginProcessingUrl("/login")
//                .and()
//                .logout().logoutSuccessHandler(new AjaxLogoutSuccessHandler())
//                .logoutUrl("/logout");
//    }

    // 安全拦截机制
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity.addFilterBefore()
        httpSecurity.csrf().disable();  // 关闭csrf安全控制,否则我们将访问不到我们自定义的登录页面
        httpSecurity.authorizeRequests()
                .antMatchers("/r/r1").hasAnyAuthority("p1")
                .antMatchers("/r/r2").hasAnyAuthority("p2")
                .antMatchers("/r/**").authenticated()  // 所有/r/**的资源都必须通过认证
                .anyRequest().permitAll() // 排除其他路径的拦截
                .and()
                .formLogin()
                .loginPage("/login-view")
                .loginProcessingUrl("/login")
                .successForwardUrl("/login-success")
                .failureUrl("/fail")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                .and()
                .logout()
                .logoutUrl("/mylogout")
                .logoutSuccessUrl("/mylogin");
//                .logoutSuccessHandler(AjaxLogoutSuccessHandler)
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);  // 配置会话管理方式
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }

}
