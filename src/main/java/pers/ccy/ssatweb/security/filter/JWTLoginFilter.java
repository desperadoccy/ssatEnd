package pers.ccy.ssatweb.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pers.ccy.ssatweb.common.RespBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * @author desperado
 * @ClassName JWTLoginFilter
 * @Description
 * @date 2020/5/5 0:40
 * @Version 1.0
 */
@Component
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {
    private ThreadLocal<Map<String, String>> threadLocal = new ThreadLocal<>();
    @Autowired
    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    @Autowired
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        super.setAuthenticationManager(authenticationManager);
    }

    @Override
    protected String obtainPassword(HttpServletRequest request) {
        String password = this.getBodyParams(request).get(super.SPRING_SECURITY_FORM_PASSWORD_KEY);
        if (!StringUtils.isEmpty(password)) {
            return password;
        }
        return super.obtainPassword(request);
    }

    @Override
    protected String obtainUsername(HttpServletRequest request) {
        String username = this.getBodyParams(request).get(super.SPRING_SECURITY_FORM_USERNAME_KEY);
        if (!StringUtils.isEmpty(username)) {
            return username;
        }
        return super.obtainUsername(request);
    }

    /**
     * 获取body参数  body中的参数只能获取一次
     *
     * @param request
     * @return
     */
    private Map<String, String> getBodyParams(HttpServletRequest request) {
        Map<String, String> bodyParams = threadLocal.get();
        if (bodyParams == null) {
            ObjectMapper objectMapper = new ObjectMapper();
            try (InputStream is = request.getInputStream()) {
                bodyParams = objectMapper.readValue(is, Map.class);
            } catch (IOException e) {
            }
            if (bodyParams == null) bodyParams = new HashMap<>();
            threadLocal.set(bodyParams);
        }

        return bodyParams;
    }

    /**
     * 接收并解析用户登陆信息  /login,
     * 为已验证的用户返回一个已填充的身份验证令牌，表示成功的身份验证
     * 返回null，表明身份验证过程仍在进行中。在返回之前，实现应该执行完成该过程所需的任何额外工作。
     * 如果身份验证过程失败，就抛出一个AuthenticationException
     *
     * @param request  从中提取参数并执行身份验证
     * @param response 如果实现必须作为多级身份验证过程的一部分(比如OpenID)进行重定向，则可能需要响应
     * @return 身份验证的用户令牌，如果身份验证不完整，则为null。
     * @throws AuthenticationException
     */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {


        //得到用户登陆信息,并封装到 Authentication 中,供自定义用户组件使用.
        String username = obtainUsername(request);
        String password = obtainPassword(request);

        if (username == null) {
            username = "";
        }

        if (password == null) {
            password = "";
        }

        username = username.trim();


        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password, authorities);

        //authenticate()接受一个token参数,返回一个完全经过身份验证的对象，包括证书.
        // 这里并没有对用户名密码进行验证,而是使用 AuthenticationProvider 提供的 authenticate 方法返回一个完全经过身份验证的对象，包括证书.
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //UsernamePasswordAuthenticationToken 是 Authentication 的实现类
        return authenticate;
    }


    /**
     * 登陆成功后,此方法会被调用,因此我们可以在此方法中生成token,并返回给客户端
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException {
        Iterator<? extends GrantedAuthority> iterator = authResult.getAuthorities().iterator();
        String id = iterator.next().toString();
//        String role = iterator.next().toString();
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim("id", id)
//                .claim("role", role)
                //有效期两小时
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 2 * 1000))
                //采用什么算法是可以自己选择的，不一定非要采用HS512
                .signWith(SignatureAlgorithm.HS512, "SSAT2020")
                .compact();

        response.addHeader("token", "SSAT-" + token);
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("username", authResult.getName());
 //       map.put("role", role);
        map.put("token", "SSAT-" + token);
        RespBean ok = RespBean.ok("登录成功", map);
        out.write(new ObjectMapper().writeValueAsString(ok));
        out.flush();
        out.close();
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        RespBean respBean = RespBean.error(exception.getMessage());
        if (exception instanceof LockedException) {
            respBean.setMsg("账户被锁定，请联系管理员!");
        } else if (exception instanceof CredentialsExpiredException) {
            respBean.setMsg("密码过期，请联系管理员!");
        } else if (exception instanceof AccountExpiredException) {
            respBean.setMsg("账户过期，请联系管理员!");
        } else if (exception instanceof DisabledException) {
            respBean.setMsg("账户被禁用，请联系管理员!");
        } else if (exception instanceof BadCredentialsException) {
            respBean.setMsg("用户名或者密码输入错误，请重新输入!");
        }
        out.write(new ObjectMapper().writeValueAsString(respBean));
        out.flush();
        out.close();
    }
}