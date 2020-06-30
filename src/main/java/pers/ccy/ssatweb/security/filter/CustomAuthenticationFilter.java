package pers.ccy.ssatweb.security.filter;

import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import pers.ccy.ssatweb.utils.GetRequestJsonUtils;
import pers.ccy.ssatweb.utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author desperado
 * @ClassName CustomAuthenticationFilter
 * @Description
 * @date 2020/6/30 16:39
 * @Version 1.0
 */
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {

        //attempt Authentication when Content-Type is json
        if (request.getContentType().equals(MediaType.APPLICATION_JSON_UTF8_VALUE)
                || request.getContentType().equals(MediaType.APPLICATION_JSON_VALUE)) {

            UsernamePasswordAuthenticationToken authRequest = null;
            try {
                String jsonString = GetRequestJsonUtils.getPostRequestJsonString(request);
                SelfUserDetails selfUserDetails = JsonUtils.jsonToPojo(jsonString,SelfUserDetails.class);
                authRequest = new UsernamePasswordAuthenticationToken(
                        selfUserDetails.getUsername(), selfUserDetails.getPassword());
            } catch (Exception e) {
                e.printStackTrace();
                authRequest = new UsernamePasswordAuthenticationToken(
                        "", "");
            } finally {
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }
        }
        //transmit it to UsernamePasswordAuthenticationFilter
        else {
            return super.attemptAuthentication(request, response);
        }
    }
}
