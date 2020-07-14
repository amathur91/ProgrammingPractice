package com.threading;

import java.util.concurrent.Semaphore;

public class MultiThreadingSemaphore {
    public static void main(String args[]){
        Semaphore oddSemaphore = new Semaphore(1);
        Semaphore evenSemaphore = new Semaphore(0);
        Printer printer = new Printer();
        Thread t1 = new Thread(() -> {
            for(int i =0; i < 10; i++) {
                try {
                    oddSemaphore.acquire();
                    printer.printNumber("Thead 1 - ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                evenSemaphore.release();
            }
        });

        Thread t2 = new Thread(()-> {
            for(int i =0; i < 10; i++) {
                try {
                    evenSemaphore.acquire();
                    printer.printNumber("Thread 2 - ");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                oddSemaphore.release();
            }
        });
        t1.start();
        t2.start();

    }
}


class Printer {
    private int counter;

    public Printer(){
        this.counter = 1;
    }
    public void printNumber(String message){
        System.out.println(message + counter++);
    }
}





