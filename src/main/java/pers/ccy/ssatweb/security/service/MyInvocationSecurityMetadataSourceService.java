package pers.ccy.ssatweb.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;
import pers.ccy.ssatweb.dao.RightDao;
import pers.ccy.ssatweb.domain.Right;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author desperado
 * @ClassName MyInvocationSecurityMetadataSourceService
 * @Description
 * @date 2020/6/9 11:11
 * @Version 1.0
 */
@Service
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {
    @Autowired
    RightDao rightDao;

    private HashMap<String, Collection<ConfigAttribute>> map = null;

    private void loadResourceDefine() {
        map = new HashMap<>();
        Collection<ConfigAttribute> array;
        ConfigAttribute configAttribute;
        List<Right> rights = rightDao.list();
        for (Right right : rights) {
            array = new ArrayList<>();
            configAttribute = new SecurityConfig(right.getName());
            array.add(configAttribute);
            map.put(right.getEndpath(), array);
        }
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        if (map == null) loadResourceDefine();
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for (Iterator<String> iterator = map.keySet().iterator(); iterator.hasNext(); ) {
            resUrl = iterator.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if (matcher.matches(request)) {
                return map.get(resUrl);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
