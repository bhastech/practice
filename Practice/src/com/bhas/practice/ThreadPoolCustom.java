package com.bhas.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class ThreadPoolCustom {

    private LinkedBlockingQueue<Runnable> queue;

    private List<WorkerThread> threadList;

    private AtomicBoolean isThreadPoolShutDownInitiated;

    public ThreadPoolCustom(int numberOfThreads){
        this.queue = new LinkedBlockingQueue<>();
        this.threadList = new ArrayList<>(numberOfThreads);
        this.isThreadPoolShutDownInitiated = new AtomicBoolean(false);

        for(int i=0;i<numberOfThreads;i++){
            WorkerThread thread = new WorkerThread(queue, this);
            thread.start();
            thread.setName("Worker Thread - " + i);
            threadList.add(thread);
        }
    }

    public void execute(Runnable r) throws Exception {
        if(!isThreadPoolShutDownInitiated.get()){
            queue.add(r);
        }else {
            throw new Exception("Shutdown initiated !!");
        }
    }

    public void shutDown(){
        isThreadPoolShutDownInitiated = new AtomicBoolean(true);
    }


    private class WorkerThread extends Thread{

        private LinkedBlockingQueue<Runnable> queue;

        private ThreadPoolCustom threadPoolCustom;

        public WorkerThread(LinkedBlockingQueue<Runnable> queue, ThreadPoolCustom threadPoolCustom) {
            this.queue = queue;
            this.threadPoolCustom = threadPoolCustom;
        }

        @Override
        public void run(){
            while(!threadPoolCustom.isThreadPoolShutDownInitiated.get() || !queue.isEmpty()){
                Runnable r;
                while ((r = queue.poll()) != null) {
                    r.run();
                }
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " is executing task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ThreadPoolCustom threadPool = new ThreadPoolCustom(2);
        threadPool.execute(r);
        threadPool.execute(r);
        threadPool.shutDown();
        // threadPool.execute(r);
    }
}



