package com.buo.queue;

import java.util.ArrayList;

public class Queue<T> {

    private final ArrayList<T> queue;

    private final Object fullQueue = new Object();
    private final Object emptyQueue = new Object();

    private final int maxSize;


    public Queue(int maxSize) {
        this.maxSize = maxSize;
        this.queue = new ArrayList<>(maxSize);
    }

    T front() {
        if (isEmpty()) {
            return null;
        }
        return queue.get(queue.size() - 1);

    }

    T rear() {
        if (isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

    void enQueue(T element) {
        queue.add(element);
    }

    T deQueue() {
        if (this.isEmpty()) {
            return null;
        } else {
            return queue.remove(0);
        }
    }

    boolean isEmpty() {
        return queue.isEmpty();
    }



    public boolean isFull() {
        return queue.size() == maxSize;
    }

    public void waitOnFull() throws InterruptedException {
        synchronized (fullQueue) {
            fullQueue.wait();
        }
    }

    public void waitOnEmpty() throws InterruptedException {
        synchronized (emptyQueue) {
            emptyQueue.wait();
        }
    }

    public void notifyAllForFull() {
        synchronized (fullQueue) {
            fullQueue.notifyAll();
        }
    }

    public void notifyAllForEmpty() {
        synchronized (emptyQueue) {
            emptyQueue.notifyAll();
        }
    }
}
