package com.example.demo.activator;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.example.demo.model.MyResponse;

@Component("globalExceptionHandler")
public class GlobalExceptionHandler {

    @SuppressWarnings("unused")
    private ConfigurableApplicationContext ctx;
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    public GlobalExceptionHandler(ConfigurableApplicationContext ctx) {
        this.ctx = ctx;
    }

    public Message<MyResponse> handleError(Message<?> message) {
        logger.error("Exception occured: {}", message.toString());

        MyResponse faultMessage = new MyResponse();
        String errorMessage;
        // faultMessage
        faultMessage.setDescription("Internal Server Error");
        faultMessage.setCode("500");

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.putAll(message.getHeaders());
        headerMap.put("http_statusCode", faultMessage.getCode());

        MessageHeaders responseHeaders = new MessageHeaders(headerMap);
        Message<MyResponse> responseMessage = MessageBuilder.createMessage(faultMessage, responseHeaders);
        return responseMessage;
    }

}
