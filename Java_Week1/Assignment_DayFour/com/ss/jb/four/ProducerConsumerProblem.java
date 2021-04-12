package com.ss.jb.four;

import java.util.ArrayList;

public class ProducerConsumerProblem {

    private ArrayList<Integer> buffer = new ArrayList<>();
    private Integer capacity = 7;

    public void produce() throws InterruptedException {
        while(true) {
            synchronized (this) {
                if (buffer.size() < capacity) {
                    buffer.add(1); // just adding '1' for this example
                }
                System.out.println("Producer added to the buffer");
            }
            Thread.sleep(1000);
        }
    }

    public void consume() throws InterruptedException {
        while(true) {
            synchronized (this) {
                if (buffer.size() > 0) {
                    buffer.remove(0); // removes index 0 Integer for this example

                }
                System.out.println("Consumer removed from the buffer");
            }
            Thread.sleep(1000);
        }
    }

    public static void main(String[] args) {
        final ProducerConsumerProblem pc = new ProducerConsumerProblem();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
    }

}



