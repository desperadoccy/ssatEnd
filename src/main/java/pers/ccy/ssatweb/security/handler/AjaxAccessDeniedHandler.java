package pers.ccy.ssatweb.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import pers.ccy.ssatweb.common.RespBean;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author desperado
 * @ClassName AjaxAccessDeniedHandler
 * @Description
 * @date 2020/6/30 16:05
 * @Version 1.0
 */
@Component
public class AjaxAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        RespBean error = RespBean.custom(300, "需要权限");
        response.getWriter().write(new ObjectMapper().writeValueAsString(error));
    }
}
