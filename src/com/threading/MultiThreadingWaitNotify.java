package com.threading;

public class MultiThreadingWaitNotify {

    public static void main(String args[]){
        PrintingMachine printingMachine = new PrintingMachine();
        Thread t1 = new Thread(()-> {
            for(int index =0; index < 10; index++) {
                try {
                    printingMachine.printOdd("Thread - 1 -> ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()-> {
            for(int index =0; index < 10; index++) {
                try {
                    printingMachine.printEven("Thread - 2 -> ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        t1.start();
        t2.start();
    }
}

class PrintingMachine{
    private int oddCounter;
    private int evenCounter;

    public PrintingMachine(){
        this.oddCounter = 1;
        this.evenCounter = 2;
    }

    public void printOdd(String message) throws InterruptedException {
        /**
         * To Acquire Lock for synchronization, the thread while executing this code
         * will enter synchronize block and hold a lock. this is required for
         * notify and wait. Some executing machine like thread has to wait on this object
         * section  and not on the whole object.
         */
        synchronized (this) {
            System.out.println(message + this.oddCounter);
            this.oddCounter += 2;
            notify();
            wait();
        }
    }

    public void printEven(String message) throws InterruptedException {
        synchronized (this) {
            System.out.println(message + this.evenCounter);
            this.evenCounter += 2;
            notify();
            wait();
        }
    }
}
