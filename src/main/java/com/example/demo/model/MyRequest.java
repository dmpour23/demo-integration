package com.example.demo.model;

public class MyRequest {

    private String msisdn;
    private String notificationType;
    private int languageId;
    private String transactionId;

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public void setNotificationType(String notificationType) {
        this.notificationType = notificationType;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "MyRequest [msisdn=" + msisdn + ", notificationType=" + notificationType + ", languageId=" + languageId + ", transactionId=" + transactionId + "]";
    }

}
