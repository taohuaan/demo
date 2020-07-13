package com.example.observer;

public class Monster implements Observer {
    @Override
    public void update(String active) {
        if(inRange(active)){
            System.out.println("怪物 对主角发动了攻击");
        }
    }
    private boolean inRange(String active){
        if("后".equals(active)){
            return true;
        }else{
            return false;
        }

    }
}
