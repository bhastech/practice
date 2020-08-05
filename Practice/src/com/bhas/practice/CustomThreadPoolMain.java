package com.bhas.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomThreadPoolMain {

    private int poolMaxCount;
    private List<ThreadPoolThread> threadList;
    private LinkedBlockingQueue<Runnable> runnables;

    public CustomThreadPoolMain(int poolMaxCount){
        this.threadList = new ArrayList<>();
        runnables = new LinkedBlockingQueue<>();
        for(int i=0;i<poolMaxCount;i++){
            ThreadPoolThread thread = new ThreadPoolThread(runnables, new AtomicBoolean(true));
            thread.start();
            threadList.add(thread);
        }
    }

    public void execute(Runnable r){
        runnables.add(r);
    }

    public static void main(String[] args) {
        CustomThreadPoolMain thred = new CustomThreadPoolMain(3);



    }


    class ThreadPoolThread extends Thread{
        private LinkedBlockingQueue<Runnable> runnables;
        private AtomicBoolean isExit;

        public ThreadPoolThread(LinkedBlockingQueue<Runnable> runnables, AtomicBoolean isExit){
            this.runnables = runnables;
            this.isExit = isExit;
        }

        @Override
        public void run(){
            while(!isExit.get() && !runnables.isEmpty()){
                for(Runnable r: runnables){
                    r.run();
                }
            }
        }
    }

}
