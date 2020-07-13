package com.example.observer;

public class Treasure implements Observer {
    @Override
    public void update(String active) {
        if(inRange(active)){
            System.out.println("宝物 给主角加血");
        }
    }
    private boolean inRange(String active){
        if("前".equals(active)){
            return true;
        }else{
            return false;
        }
    }
}