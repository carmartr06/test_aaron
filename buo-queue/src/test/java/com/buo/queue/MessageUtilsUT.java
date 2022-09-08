package com.buo.queue;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageUtilsUT {

    @Test
    public void whenProcessMessageThenReturnOnly11ValidCharacters() {
        assertEquals(11, MessageUtils.process(new Message("234567834567890")).replace("-", "").length());
    }

}
