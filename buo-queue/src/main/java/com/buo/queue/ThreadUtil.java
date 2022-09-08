package com.buo.queue;

import java.util.List;

public class ThreadUtil {
    public static void waitForAllThreads(List<Thread> threads) {
        for(Thread thread: threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sleep(long interval) {
        try {
            Thread.sleep(interval);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
