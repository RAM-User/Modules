package com.chapter8;

class Instrument {
    public void play(Note n) {
        System.out.println("Instrument.play()");
    }
}
public class Wind extends Instrument {
    @Override
    public void play(Note n) {
        System.out.println("Wind.play()" + n);
    }

    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
       Wind flute = new Wind();
        tune(flute);
    }
}
