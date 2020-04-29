package pers.ccy.ssatweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import pers.ccy.ssatweb.articleAndNews.common.Status;
import pers.ccy.ssatweb.articleAndNews.common.StatusCode;

@SpringBootTest
class SsatWebApplicationTests {

    @Test
    void contextLoads() {
        Status status = new Status();
        status.setStatusCode(StatusCode.SUCCESS);
        status.setMessage("上传成功");
        System.out.println(status);
    }

}
