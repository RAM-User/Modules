package com.chapter8;

class Super {
    public int field = 0;
    public int getField() {
        return field;
    }
}
class Sub extends Super {
    public int field = 1;
    public int getField() {
        return field;
    }
    public int getSuperField() {
    return super.field;
    }
}
public class FieldAccess {
    public static void main(String[] args) {
        Super sub = new Sub();
        System.out.println("sup.field = " + sub.field + " sup.getField = " + sub.getField());

        Sub sub1 = new Sub();
        System.out.println("sup1.field = " + sub1.field + " sup1.getField = " + sub1.getField());
    }
}
