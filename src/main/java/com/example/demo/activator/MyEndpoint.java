package com.example.demo.activator;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import com.example.demo.model.MyRequest;
import com.example.demo.model.MyResponse;

public class MyEndpoint {
    private static final Logger logger = LoggerFactory.getLogger(MyEndpoint.class);

    private static final String STATUSCODE_HEADER = "http_statusCode";

    // @Secured("ROLE_USER")
    public Message<MyResponse> handle(Message<MyRequest> message) {
        // try {
        logger.info("-----------------------------------");
        logger.info("Received {}", message);
        if (message.getPayload().getLanguageId() == 5) {
            throw new RuntimeException("This is caught by exceptionHandler");
        }
        MyResponse resp = new MyResponse();
        resp.setTransactionId(message.getPayload().getTransactionId());
        resp.setNotificationRequestId(UUID.randomUUID().toString());

        return MessageBuilder.withPayload(resp)
            .copyHeadersIfAbsent(message.getHeaders())
            .setHeader(STATUSCODE_HEADER, HttpStatus.OK)
            .build();

    }

}
