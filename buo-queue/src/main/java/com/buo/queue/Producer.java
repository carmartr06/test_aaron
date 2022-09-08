package com.buo.queue;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    private final Queue<Message> messageQueue;
    private final boolean runFlag;


    public Producer(Queue<Message> messageQueue) {
        this.messageQueue = messageQueue;
        runFlag = true;
    }

    @Override
    public void run() {
        produce();
    }

    public void produce() {
        //No entendi muy bien el tema de las interacciones pero lo que entendi deberia ir aca un limite de por ejemplo 15
        while (runFlag) {
            Message message = new Message(generatePhoneNumber());
            while (messageQueue.isFull()) {
                try {
                    messageQueue.waitOnFull();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            if (!runFlag) {
                break;
            }
            messageQueue.enQueue(message);
            messageQueue.notifyAllForEmpty();
        }
    }



    String generatePhoneNumber() {
        final List<String> stringList = Arrays.asList("80083377778", "800TEST", "8", "88888");
        return stringList.get(new Random().nextInt(stringList.size()));
    }
}
