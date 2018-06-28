package ru.kscsq.tinkofftest.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.kscsq.tinkofftest.TestData.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationControllerITTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @org.junit.jupiter.api.Test
    public void getAllApplicationsTest() {
        String message = this.restTemplate.getForObject("/api/applications/", String.class);
        assertEquals(JSON_GET_ALL, message);
    }

    @org.junit.jupiter.api.Test
    public void getApplication5Test() {
        String message = this.restTemplate.getForObject("/api/applications/5", String.class);
        assertEquals(JSON_GET_5, message);
    }

    @org.junit.jupiter.api.Test
    public void badRequestTest() {
        String message = this.restTemplate
                .getForObject("/api/applications/bad", String.class).substring(23, 34);
        assertEquals(BAD, message);
    }

    @org.junit.jupiter.api.Test
    public void notFoundRequestTest(){
        String message = this.restTemplate
                .getForObject("/api/applications/555", String.class).substring(23, 32);
        assertEquals(NOT_FOUND, message);

    }
}