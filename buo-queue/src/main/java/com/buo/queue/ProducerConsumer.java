package com.buo.queue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static com.buo.queue.ThreadUtil.waitForAllThreads;


@RefreshScope
@Configuration
public class ProducerConsumer {

    @Value("${producers.max}")
    private int maxProducers;

   @Value("${consumers.max}")
    private int maxConsumers;

    @Value("${queue.size}")
    private int queueSize;

    @PostConstruct
    public void init() {

        Queue<Message> messageQueue  = new Queue<>(queueSize);

        List<Thread> threads = new ArrayList<>();
        Producer producer = new Producer(messageQueue);
        for(int i = 0; i < maxProducers; i++) {
            Thread threadProd = new Thread(producer);
            threadProd.start();
            threads.add(threadProd);
        }
        Consumer consumer = new Consumer(messageQueue);
        for(int i = 0; i < maxConsumers; i++) {
            Thread threadCons = new Thread(consumer);
            threadCons.start();
            threads.add(threadCons);
        }
        waitForAllThreads(threads);
    }
}
