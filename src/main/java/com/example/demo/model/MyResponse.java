package com.example.demo.model;

public class MyResponse {

    private String notificationRequestId;
    private String transactionId;
    private String description;
    private String code;

    public String getNotificationRequestId() {
        return notificationRequestId;
    }

    public void setNotificationRequestId(String notificationRequestId) {
        this.notificationRequestId = notificationRequestId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "MyResponse [notificationRequestId=" + notificationRequestId + ", transactionId=" + transactionId + ", description=" + description + ", code=" + code + "]";
    }

}
