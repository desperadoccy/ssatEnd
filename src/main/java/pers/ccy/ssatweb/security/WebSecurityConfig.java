package pers.ccy.ssatweb.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.security.filter.JWTAuthenticationFilter;
import pers.ccy.ssatweb.security.filter.JWTLoginFilter;
import pers.ccy.ssatweb.security.provider.CustomAuthenticationProvider;
import pers.ccy.ssatweb.security.service.CustomUserDetailsService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author desperado
 * @ClassName WebSecurityConfig
 * @Description
 * @date 2020/5/2 20:37
 * @Version 1.0
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();
        roleHierarchy.setHierarchy("ROLE_admin > ROLE_editor");
        return roleHierarchy;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new CustomAuthenticationProvider(userDetailsService, passwordEncoder));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                // 所有请求需要身份认证
                .anyRequest().permitAll()
                .and()
                //验证登陆
                .addFilter(new JWTLoginFilter(authenticationManager()))
                //验证token
                .addFilter(new JWTAuthenticationFilter(authenticationManager()));
//        http
//                .csrf().disable()
//                //认证失败处理类
//                .exceptionHandling()
//                .authenticationEntryPoint((req, resp, authentication) -> {
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write(new ObjectMapper().writeValueAsString(RespBean.ok("请登录!")));
//                    out.flush();
//                    out.close();
//                })
//                .and()
//                //基于token，不需要session
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                //放行所有请求，权限设置在接口上
//                .authorizeRequests()
//                .anyRequest().permitAll()
//                .and()
//                .addFilter(new JWTLoginFilter(authenticationManager()))
//                .addFilter(new JWTAuthenticationFilter(authenticationManager()));
//                .logout()
//                .logoutSuccessHandler((req, resp, authentication) -> {
//                    resp.setContentType("application/json;charset=utf-8");
//                    PrintWriter out = resp.getWriter();
//                    out.write(new ObjectMapper().writeValueAsString(RespBean.ok("注销成功!")));
//                    out.flush();
//                    out.close();
//                })
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .permitAll()
//                .and()
//        http.logout().logoutUrl("/logout").logoutSuccessHandler(logoutSuccessHandler);
//        http.addFilterBefore(authenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        http.addFilterAt(customAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

//    @Bean
//    CustomAuthenticationFilter customAuthenticationFilter() throws Exception {
//        CustomAuthenticationFilter filter = new CustomAuthenticationFilter();
//        filter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
//            @Override
//            public void onAuthenticationFailure(HttpServletRequest req, HttpServletResponse resp, AuthenticationException exception) throws IOException, ServletException {
//                resp.setContentType("application/json;charset=utf-8");
//                PrintWriter out = resp.getWriter();
//                RespBean respBean = RespBean.error(exception.getMessage());
//                if (exception instanceof LockedException) {
//                    respBean.setMsg("账户被锁定，请联系管理员!");
//                } else if (exception instanceof CredentialsExpiredException) {
//                    respBean.setMsg("密码过期，请联系管理员!");
//                } else if (exception instanceof AccountExpiredException) {
//                    respBean.setMsg("账户过期，请联系管理员!");
//                } else if (exception instanceof DisabledException) {
//                    respBean.setMsg("账户被禁用，请联系管理员!");
//                } else if (exception instanceof BadCredentialsException) {
//                    respBean.setMsg("用户名或者密码输入错误，请重新输入!");
//                }
//                out.write(new ObjectMapper().writeValueAsString(respBean));
//                out.flush();
//                out.close();
//            }
//        });
//    }
}
