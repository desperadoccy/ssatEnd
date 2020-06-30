package pers.ccy.ssatweb.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import pers.ccy.ssatweb.common.RespBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author desperado
 * @ClassName AjaxLogoutSuccessHandler
 * @Description
 * @date 2020/6/30 16:24
 * @Version 1.0
 */
@Component
public class AjaxLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        RespBean ok = RespBean.ok("登出成功");
        response.getWriter().write(new ObjectMapper().writeValueAsString(ok));
    }
}
