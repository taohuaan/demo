package com.example.state;

public class StartState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Game is in start time");
        System.out.println("this :" +this);
        context.setState(this);
    }
    public String toString(){
        return "Start State";
    }
}
