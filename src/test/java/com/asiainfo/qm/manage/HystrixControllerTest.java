package com.asiainfo.qm.manage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HystrixControllerTest {
    @Autowired
    TestRestTemplate testRestTemplate;
    private String baseurl = "/demo/microservice";

    @Test
    public void test1() throws Exception {
                testRestTemplate.getForEntity(baseurl + "/defaultHystrix", String.class);
    }

    @Test
    public void testFallbackDemo() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/testFallbackDemo/{id}",
                        String.class, "1");
    }

    @Test
    public void noFallback() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/noFallback",
                        String.class);
    }

    @Test
    public void reactiveExecution() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/reactiveExecution",
                        String.class);
    }

    @Test
    public void testAsync() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/testAsync",
                        String.class);
    }

    @Test
    public void testSyn() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/testSyn",
                        String.class);
    }

    @Test
    public void testSyn2() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/testSyn2",
                        String.class);
    }

    @Test
    public void semaphore() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/semaphore",
                        String.class);
    }

    @Test
    public void threadpool() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/threadpool",
                        String.class);
    }

    @Test
    public void withornotfallback() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/testfallback",
                        String.class);
    }


    @Test
    public void testignoreexception() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/testignoreexception",
                        String.class);
    }

    @Test
    public void testCache() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/testCache",
                        String.class);
    }

    @Test
    public void testCollapserAsync() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/testCollapserAsync",
                        String.class);
    }

    @Test
    public void concurrency() throws Exception {
                testRestTemplate.getForEntity(
                        baseurl + "/concurrency",
                        String.class);
    }

}