package com.example.observer;

import java.util.ArrayList;
import java.util.List;

abstract public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    public void attachObserver(Observer observer){
        observers.add(observer);
    }
    public void detachObserver(Observer observer){
        observers.remove(observer);
    }
    public void notifyObserver(String active){
        for(Observer observer :observers){
            observer.update(active);
        }
    }
}
