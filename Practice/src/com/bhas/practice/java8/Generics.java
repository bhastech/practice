package com.bhas.practice.java8;

import java.util.LinkedList;
import java.util.Queue;

public class Generics{

}


interface BlockingQueueCustom<E>{

    void put(E e);

    E take();
}

class CustomBlockingQueue<E> implements BlockingQueueCustom<E>{

    private Queue<E> queue;
    int maxSize;
    public CustomBlockingQueue(int size) {
        this.queue = new LinkedList<E>();
        this.maxSize = size;
    }

    @Override
    public void put(E e) {
        if(queue.size() == maxSize){
            try {
                wait();
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
        queue.add(e);
        notify();
    }

    @Override
    public E take() {
        if(queue.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        E poll = queue.poll();
        notify();
        return poll;
    }
}

class Producer implements Runnable{


    public Producer() {
    }

    @Override
    public void run() {

    }
}