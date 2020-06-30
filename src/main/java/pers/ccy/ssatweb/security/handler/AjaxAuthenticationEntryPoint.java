package pers.ccy.ssatweb.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import pers.ccy.ssatweb.common.RespBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author desperado
 * @ClassName AjaxAuthenticationEntryPoint
 * @Description
 * @date 2020/6/30 16:11
 * @Version 1.0
 */
@Component
public class AjaxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        RespBean error = RespBean.custom(301, "未登录");
        response.getWriter().write(new ObjectMapper().writeValueAsString(error));
    }
}
