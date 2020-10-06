package com.example.demo;

import java.net.URL;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.MyRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoIntegrationApplicationTests {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @BeforeEach
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/demo");
    }

    @Test
    public void testshouldPassValidator() throws JSONException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "application/json");
        MyRequest req = new MyRequest();
        req.setLanguageId(1);
        req.setTransactionId("0005");
        req.setNotificationType("SMS");
        req.setMsisdn("5");

        HttpEntity<MyRequest> request = new HttpEntity<>(req, headers);

        System.out.println(req);
        String response = template.postForObject(base.toString(), request, String.class);
        System.out.println(response);
    }

    @Test
    public void testFailsValidator() throws JSONException {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "application/json");

        MyRequest req = new MyRequest();
        req.setLanguageId(1);
        req.setTransactionId("0005");
        req.setNotificationType("SMS");
        req.setMsisdn("");

        HttpEntity<MyRequest> request = new HttpEntity<>(req, headers);

        System.out.println(request);
        String response = template.postForObject(base.toString(), request, String.class);
        System.out.println(response);
    }

}
