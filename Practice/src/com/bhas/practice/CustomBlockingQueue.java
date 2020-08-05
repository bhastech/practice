package com.bhas.practice;

import java.util.LinkedList;
import java.util.Queue;

public class CustomBlockingQueue<E> implements ICustomBlockingQueue<E> {

    public static void main(String[] args) {
        CustomBlockingQueue<String> queue = new CustomBlockingQueue<>(5);
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumetThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumetThread.start();


//        System.out.println(Boolean.valueOf(true).toString());

    }


    public Queue<E> elementList;

    int maxSize;

    public CustomBlockingQueue(int maxSize) {
        this.maxSize = maxSize;
        elementList = new LinkedList<E>();
    }

    @Override
    public synchronized void put(E e) {
        if (elementList.size() == maxSize) {
            try {
                System.out.println("reached max size...going to wait");
                wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        elementList.add(e);
        notifyAll();
    }

    @Override
    public synchronized E take() {
        if (elementList.size() == 0) {
            System.out.println("Queue size zero...going to wait");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        E e = elementList.poll();
        notifyAll();
        return e;
    }
}

interface ICustomBlockingQueue<E> {

    void put(E e);

    E take();

}





class Producer implements Runnable{

    CustomBlockingQueue<String> queue;

    public Producer(CustomBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Producing ::: "+i);
            queue.put("Element -- "+i);
        }
    }
}


class Consumer implements Runnable{

    CustomBlockingQueue<String> queue;

    public Consumer(CustomBlockingQueue<String> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println((String)queue.take());
        }
    }
}