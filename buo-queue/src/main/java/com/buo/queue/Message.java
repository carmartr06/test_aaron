package com.buo.queue;

public class Message {
    private String phoneNumber;

    public Message(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Message{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
