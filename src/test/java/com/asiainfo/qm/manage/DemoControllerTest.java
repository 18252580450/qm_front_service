package com.asiainfo.qm.manage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    private String baseurl = "/demo/microservice";

    @Test
    public void getDemoResponse() throws Exception {
        ResponseEntity<String> result = testRestTemplate.getForEntity(baseurl+"/{number}/{flag}", String.class, "18600000000", "1");
        assertEquals(result.getStatusCode(), HttpStatus.OK);
    }


    @Test
    public void loglevel() throws Exception {
        ResponseEntity<String> result = testRestTemplate.getForEntity(baseurl + "/loglevel", String.class);
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

}