package pers.ccy.ssatweb.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import pers.ccy.ssatweb.security.LoginUser;
import pers.ccy.ssatweb.utils.ServletUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author desperado
 * @ClassName UserLoginService
 * @Description
 * @date 2020/6/3 10:44
 * @Version 1.0
 */
@Component
public class UserLoginService {
    /**
     * 获取当前app登录用户
     * @return 用户数据
     */
    public LoginUser getLoginUser() {
        System.out.println(ServletUtil.getRequest().getHeader("token"));
        return getLoginUser(ServletUtil.getRequest());
    }

    /**
     * 获取当前操作状态下的用户
     * @param request servlet request
     * @return 用户信息
     */
    public LoginUser getLoginUser(HttpServletRequest request) {
        try {
            String token = getToken(request);
            Claims claims = Jwts.parser().setSigningKey("SSAT2020")
                    .parseClaimsJws(token)
                    .getBody();
            LoginUser user = new LoginUser();
            //得到用户名
            String username = claims.getSubject();
            String role = (String) claims.get("role");
            Integer id = Integer.parseInt((String) claims.get("id"));
            user.setRole(role);
            user.setUsername(username);
            user.setId(id);
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String getToken(HttpServletRequest request) {
        String token = request.getHeader("token");
        if (!token.isEmpty() && token.startsWith("SSAT-")) {
            token = token.replace("SSAT-", "");
        }
        return token;
    }
}
