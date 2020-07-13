package com.example.observer;

public class Trap implements Observer {
    @Override
    public void update(String active) {
        if(inRange(active)){
            System.out.println("陷阱 困住主角");
        }
    }
    private boolean inRange(String active){
        if("左".equals(active)){
            return true;
        }else{
            return false;
        }
    }
}