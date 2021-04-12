package com.ss.jb.four;

public class DeadlockExample {

    public static void main(String[] args) {
        Integer intOne = new Integer(5);
        Integer intTwo = new Integer(10);

        Runnable t1 = new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (intOne) {
                        Thread.sleep(100);
                        synchronized (intTwo) {
                            System.out.println("Thread 1 has acquired locks for intOne & intTwo");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable t2 = new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (intTwo) {
                        Thread.sleep(100);
                        synchronized (intOne) {
                            System.out.println("Thread 2 has acquired locks for intOne & intTwo");
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(t1).start();
        new Thread(t2).start();

    }





}
