package pers.ccy.ssatweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableConfigurationProperties
@SpringBootApplication
public class SsatWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsatWebApplication.class, args);
    }

}
