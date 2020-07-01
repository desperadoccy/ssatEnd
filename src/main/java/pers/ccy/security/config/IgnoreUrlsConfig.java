package pers.ccy.security.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * @author desperado
 * @ClassName SecurityConfig
 * @Description 用于配置不需要保护的资源路径
 * @date 2020/7/1 15:01
 * @Version 1.0
 */
@ConfigurationProperties(prefix = "secure.ignored")
public class IgnoreUrlsConfig {

    private List<String> urls = new ArrayList<>();

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }
}
