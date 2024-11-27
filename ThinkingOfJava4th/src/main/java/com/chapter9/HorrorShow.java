package com.chapter9;

interface Monster {
    void menace();
}
interface DangerousMonster extends Monster {
    void destroy();
}
interface Lethal {
    void kill();
}
class DragonZilla implements DangerousMonster {

    @Override
    public void menace() {
    }

    @Override
    public void destroy() {
    }
}
interface Vampire extends DangerousMonster, Lethal {
    void drinkBlood();
}
class VeryBadVampire implements Vampire {

    @Override
    public void menace() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void kill() {
    }

    @Override
    public void drinkBlood() {
    }
}

public class HorrorShow {
    static void u(Monster monster) {
        monster.menace();
    }
    static void v(DangerousMonster d) {
        d.menace();
        d.destroy();
    }
    static void w(Lethal l) {
        l.kill();
    }

    public static void main(String[] args) {
        DragonZilla dragonZilla = new DragonZilla();
        u(dragonZilla);
        v(dragonZilla);
        VeryBadVampire veryBadVampire = new VeryBadVampire();
        u(veryBadVampire);
        v(veryBadVampire);
        w(veryBadVampire);
    }
}
