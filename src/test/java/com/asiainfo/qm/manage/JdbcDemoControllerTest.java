package com.asiainfo.qm.manage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JdbcDemoControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    @Test
    public void getUserId() throws Exception {
        assertEquals(HttpStatus.OK, testRestTemplate.getForEntity(
                "/demo/microservice/jdbc?provinceCode={p}&serialNumber={s}",
                String.class,
                "11","18600000000").getStatusCode());
    }

}