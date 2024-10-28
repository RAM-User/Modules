package com.chapter15;

import java.util.List;

interface SuperPower {
}

interface XRayVision extends SuperPower {
    void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
    void hearSubtleNoise();
}

interface SuperSmell extends SuperPower {
    void trackBySmell();
}

class SuperHero<POWER extends SuperPower> {
    POWER power;

    public SuperHero(POWER power) {
        this.power = power;
    }

    public POWER getPower() {
        return power;
    }
}

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER> {

    public SuperSleuth(POWER power) {
        super(power);
    }

    void see() {
        power.seeThroughWalls();
    }
}

class SuperHearingSmell implements SuperHearing, SuperSmell {


    @Override
    public void hearSubtleNoise() {
    }

    @Override
    public void trackBySmell() {
    }
}

class CanineHero<POWER extends SuperHearing & SuperSmell> extends SuperHero<POWER> {

    public CanineHero(POWER power) {
        super(power);
    }
    void hear() {
        power.hearSubtleNoise();
    }
    void smell() {
        power.trackBySmell();
    }
}

class DogBoy extends CanineHero<SuperHearingSmell> {

    DogBoy() {
        super(new SuperHearingSmell());
    }
}

public class EpicBattle {
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoise();
    }

    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoise();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        superFind(dogBoy);
        List<? extends SuperHearing> audioBoys;
    }
}

