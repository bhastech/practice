package com.bhas.practice.java8;

public class Singleton {

    private Singleton(){

    }

    public static Singleton INSTANCE = null;

    public Singleton getInstance(){
        synchronized (this){
            if(INSTANCE == null){
                synchronized (this){
                    INSTANCE = new Singleton();
                }
            }
        }

        return INSTANCE;
    }

    protected Object readResolve() {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
    }
