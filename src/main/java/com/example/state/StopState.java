package com.example.state;

public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Game is stop mode");
        System.out.println("this :" +this);
        context.setState(this);
    }
    public String toString(){
        return "Pause";
    }
}
