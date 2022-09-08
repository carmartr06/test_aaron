package com.buo.queue;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

public class QueueUT {

    @Test
    public void whenQueueInvokeConstructor_ThenMaxSizeEquals10() throws NoSuchFieldException, IllegalAccessException {
        Queue<String> stringQueue = new Queue<>(10);
        Field field = stringQueue.getClass().getDeclaredField("maxSize");
        field.setAccessible(true);
        assertEquals(10, field.getInt(stringQueue));
    }

    @Test
    public void whenQueueInvokeConstructor_ThenQueueIsNotNull() throws NoSuchFieldException, IllegalAccessException {
        Queue<String> stringQueue = new Queue<String>(10);
        Field field = stringQueue.getClass().getDeclaredField("queue");
        field.setAccessible(true);
        assertNotNull(field.get(stringQueue));
    }

    @Test
    public void whenQueueEnqueueOneElementAndRetrieveFrontAndRearElementThenReturnTheSameObject() {
        Queue<String> stringQueue = new Queue<>(10);
        stringQueue.enQueue("One");
        assertSame(stringQueue.front(), stringQueue.rear());
    }

    @Test
    public void whenQueueEnqueueMultipleElementsAndRetrieveFrontAndRearElementThenReturnNotTheSameObject() {
        Queue<String> stringQueue = new Queue<>(10);
        stringQueue.enQueue("One");
        stringQueue.enQueue("Two");
        assertNotSame(stringQueue.front(), stringQueue.rear());
    }

    @Test
    public void whenQueueIsEmptyAndDequeueIsInvokedThenReturnNull(){
        Queue<String> stringQueue = new Queue<>(10);
        assertNull(stringQueue.deQueue());
    }

}
