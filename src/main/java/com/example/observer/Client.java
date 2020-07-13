package com.example.observer;

public class Client {
    public static void main(String[] args) {
        Hero hero = new Hero();
        Monster monster = new Monster();
        Trap trap = new Trap();
        Treasure treasure = new Treasure();
        hero.attachObserver(monster);
        hero.attachObserver(trap);
        hero.attachObserver(treasure);
        hero.move("前");
        System.out.println("主角移动了一步");
        hero.move("后");
        System.out.println("主角移动了一步");
        hero.move("左");
        System.out.println("主角移动了一步");
        hero.move("右");
        System.out.println("主角移动了一步");
    }
}
