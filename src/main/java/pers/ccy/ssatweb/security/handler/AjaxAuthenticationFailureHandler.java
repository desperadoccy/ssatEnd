package pers.ccy.ssatweb.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import pers.ccy.ssatweb.common.RespBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author desperado
 * @ClassName AjaxAuthenticationFailureHandler
 * @Description
 * @date 2020/6/30 16:12
 * @Version 1.0
 */
@Component
public class AjaxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        RespBean error = RespBean.custom(400, "登录失败");
        response.getWriter().write(new ObjectMapper().writeValueAsString(error));
    }
}
