package pers.ccy.security.service;

import org.springframework.security.access.ConfigAttribute;

import java.util.Map;

/**
 * @author desperado
 * @ClassName SecurityConfig
 * @Description 动态权限相关业务类
 * @date 2020/7/1 15:01
 * @Version 1.0
 */
public interface DynamicSecurityService {
    /**
     * 加载资源ANT通配符和资源对应MAP
     */
    Map<String, ConfigAttribute> loadDataSource();
}
