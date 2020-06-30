package pers.ccy.ssatweb.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import pers.ccy.ssatweb.common.RespBean;
import pers.ccy.ssatweb.utils.JwtTokenUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author desperado
 * @ClassName AjaxAuthenticationSuccessHandler
 * @Description
 * @date 2020/6/30 16:13
 * @Version 1.0
 */
public class AjaxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        RespBean ok = RespBean.ok("登陆成功");
        SelfUserDetails selfUserDetails = (SelfUserDetails) authentication.getPrincipal();

        // 创建 token ，并返回 ，设置过期时间为 300 秒
        String jwtToken = JwtTokenUtil.generateToken(selfUserDetails.getUsername(), 300);
        ok.setJwtToken(jwtToken);
        response.getWriter().write(new ObjectMapper().writeValueAsString(ok));
    }
}
