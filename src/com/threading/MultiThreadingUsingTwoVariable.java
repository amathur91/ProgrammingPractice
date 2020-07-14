package com.threading;

public class MultiThreadingUsingTwoVariable {
    volatile static boolean isOddCompleted = false;
    volatile static boolean isEvenCompleted = true;

    public static void main(String args[]){
        PrinterMachine printingMachine = new PrinterMachine();

        Thread t1 = new Thread(()-> {
            for(int index =0; index < 10; index++) {
                while(!isEvenCompleted){
                }
                printingMachine.print("Thread - 1 -> ");
                isEvenCompleted = false;
                isOddCompleted = true;
            }
        });

        Thread t2 = new Thread(()-> {
            for(int index =0; index < 10; index++) {
                while(!isOddCompleted){
                }
                printingMachine.print("Thread - 2 -> ");
                isOddCompleted = false;
                isEvenCompleted = true;
            }
        });

        t1.start();
        t2.start();

    }
}


class PrinterMachine{
    private int counter;

    public PrinterMachine(){
        this.counter = 1;
    }

    public synchronized void  print(String message){
        System.out.println(message + this.counter);
        this.counter++;
    }

}

