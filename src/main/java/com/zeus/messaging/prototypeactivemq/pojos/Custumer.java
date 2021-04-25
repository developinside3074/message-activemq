package com.zeus.messaging.prototypeactivemq.pojos;

public class Custumer {

    public Custumer(String customerId, String fullName) {
        this.customerId = customerId;
        this.fullName = fullName;
    }

    private final String customerId;
    private final String fullName;

    public String getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }
}
