package com.chapter9;

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {
    }
}

class Hero extends ActionCharacter implements CanFight, CanSwim, CanFly {

    @Override
    public void swim() {
    }

    @Override
    public void fly() {
    }
}

public class Adventure {
    public static void t(CanFight canFight) {
        canFight.fight();
    }

    public static void u(CanSwim canSwim) {
        canSwim.swim();
    }

    public static void v(CanFly canFly) {
        canFly.fly();
    }

    public static void w(ActionCharacter actionCharacter) {
        actionCharacter.fight();
    }

    public static void main(String[] args) {
        Hero hero = new Hero();
        t(hero);
        u(hero);
        v(hero);
        w(hero);
    }
}
