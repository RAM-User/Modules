package com.chapter7;

class Cleanser {
    private String s = "Cleanser";
    public void append(String a) {
        s += a;
    }
    public void dilute() {
        append("dilute ");
    }
    public void apply() {
        append("apply() ");
    }
    public void scrub() {
        append("scrub() ");
    }

    @Override
    public String toString() {
        return "Cleanser{" +
                "s='" + s + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Cleanser cleanser = new Cleanser();
        cleanser.dilute();
        cleanser.apply();
        cleanser.scrub();
        System.out.println(cleanser);
    }
}
public class Detergent extends Cleanser{
    public void scrub() {
        append(" detergent.scrub()");
        super.scrub();
    }

    public void foam() {
        append(" foam()");
    }

    public static void main(String[] args) {
        Detergent detergent = new Detergent();
        detergent.dilute();
        detergent.apply();
        detergent.scrub();
        detergent.foam();
        System.out.println(detergent);
        System.out.println("--------");
        Cleanser.main(args);
    }
}
