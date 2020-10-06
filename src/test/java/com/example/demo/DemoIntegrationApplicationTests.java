package com.example.demo;

import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.MyResponse;

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
    public void testPassValidator() throws JSONException {

        HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "application/json");
        JSONObject myRequest = new JSONObject();
        myRequest.put("msisdn", "55765");
        myRequest.put("languageId", 5);
        myRequest.put("transactionId", "00055765");
        myRequest.put("notificationType", "SMS");

        String string = myRequest.toString();
        System.out.println(string);
        MyResponse response = template.postForObject(base.toString(), string, MyResponse.class);
        System.out.println(response);
    }

    @Test
    public void testFailsValidator() throws JSONException {

        HttpHeaders headers = new HttpHeaders();
        // headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Accept", "application/json");
        JSONObject myRequest = new JSONObject();
        myRequest.put("msisdn", "");
        myRequest.put("languageId", 5);
        myRequest.put("transactionId", "00055765");
        myRequest.put("notificationType", "SMS");

        String string = myRequest.toString();
        System.out.println(string);
        MyResponse response = template.postForObject(base.toString(), string, MyResponse.class);
        System.out.println(response);
    }

}
