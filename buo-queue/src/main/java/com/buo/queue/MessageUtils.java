package com.buo.queue;

import java.util.Collections;

public class MessageUtils {

    public static String process(Message message) {

        String phoneNumber = message.getPhoneNumber().replace("TEST", "83377778");
        if (phoneNumber.length() < 11) {
            phoneNumber = phoneNumber + String.join("", Collections.nCopies(11 - phoneNumber.length(), "0"));
        }
        phoneNumber = phoneNumber.substring(0, 11);


        ThreadUtil.sleep(1000);
        return (phoneNumber.substring(0, 3) + "-" + phoneNumber.substring(3, 6) + "-" + phoneNumber.substring(6));
    }
}
