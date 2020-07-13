package com.example.observer;

public class Hero extends Subject {
    void move(String active){
        System.out.println("主角移动了");
        notifyObserver(active);
    }
}
