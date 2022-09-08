package com.buo.queue;


public class Consumer implements Runnable {
    private final Queue<Message> messageQueue;
    private final boolean runFlag;

    public Consumer(Queue<Message> messageQueue) {
        this.messageQueue = messageQueue;
        runFlag = true;
    }

    @Override
    public void run() {
        consume();
    }

    public void consume() {
        while (runFlag) {
            Message message;
            if (messageQueue.isEmpty()) {
                try {
                    messageQueue.waitOnEmpty();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            if (!runFlag) {
                break;
            }
            message = messageQueue.deQueue();
            messageQueue.notifyAllForFull();
            MessageUtils.process(message);
        }
    }
}
