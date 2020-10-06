package com.example.demo.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class MyRequestValidator implements Validator {

    private static final Logger logger = LoggerFactory.getLogger(MyRequestValidator.class);

    @Override
    public boolean supports(Class<?> clazz) {
        return MyRequest.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        logger.warn("validatorCalled");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "msisdn", "msisdn.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "notificationType", "notificationType.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "transactionId", "transactionId.required");
    }

}
