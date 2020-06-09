package pers.ccy.ssatweb.security.service;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import javax.security.auth.login.Configuration;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author desperado
 * @ClassName MyAccessDecisionManager
 * @Description
 * @date 2020/6/9 10:30
 * @Version 1.0
 */
@Service
public class MyAccessDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
        if (configAttributes == null || configAttributes.size() <= 0)
            return;
        ConfigAttribute c;
        String needRole;
        for (Iterator<ConfigAttribute> iterator = configAttributes.iterator(); iterator.hasNext();){
            c = iterator.next();
            needRole = c.getAttribute();
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needRole.trim().equals(grantedAuthority.getAuthority())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("no right");
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
