package com.bhas.practice;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThread {

    public static void main(String[] args) {
        Print print = new Print(true);
        Thread t1 = new Thread(()->print.printEven());
        Thread t2 = new Thread(()->print.printOdd());
//        ExecutorService executorService = Executors.newFixedThreadPool(2);
//        executorService.submit(t1);
//        executorService.submit(t2);
//        executorService.shutdown();
        //
        PrintHelloWorld printHelloWorld = new PrintHelloWorld(true);
        Thread helloThread = new Thread(()->printHelloWorld.printHello());
        Thread worldThread = new Thread(()->printHelloWorld.printWorld());

        ExecutorService executorService1 = Executors.newFixedThreadPool(2);
        executorService1.submit(helloThread);
        executorService1.submit(worldThread);
        executorService1.shutdown();
        //

    }
}

class PrintHelloWorld{
    boolean flag;
    int ii = 0;

    public PrintHelloWorld(boolean flag){
        this.flag = flag;
    }

    public void printHello(){
        while(ii<100){
            synchronized (this){
                if(flag){
                    System.out.print("Hello ");
                    flag = false;
                    ii++;
                    notify();
                }else{
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void printWorld(){
        while(ii<100){
            synchronized (this){
                if(!flag){
                    System.out.println("World !");
                    flag = true;
                    ii++;
                    notify();
                }else{
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}


class Print {
    boolean odd;
    int count = 1;
    int max_count = 10;

    public Print(boolean b) {
        odd = b;
    }

    public void printOdd() {
        synchronized (this) {
            while (count < max_count) {
                while (!odd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Print Odd : " + count);
                count++;
                odd = false;
                notify();
            }
        }
    }

    public void printEven() {
        synchronized (this) {
            while (count < max_count) {
                while (odd) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Print Even : " + count);
                count++;
                odd = true;
                notify();
            }
        }
    }
}
