package com.basicSpring.model;

import java.util.List;

public class MessageAndPhones {
    String message;
    List<String> phones;

    public String getMessage() {
        return message;
    }

    public List<String> getPhones() {
        return phones;
    }

    public MessageAndPhones(String message, List<String> phones) {
        this.message = message;
        this.phones = phones;
    }
}