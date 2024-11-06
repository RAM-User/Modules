package com.chapter7;

class WaterSource {
    private String s;

    WaterSource() {
        System.out.println("WaterSource()");
        s = "Constructed";
    }

    @Override
    public String toString() {
        return "s='" + s + '\'' + '}';
    }
}

public class SprinklerSystem {
    private String v1, v2, v3, v4;
    private WaterSource waterSource = new WaterSource();
    private int i;
    private float f;

    @Override
    public String toString() {
        return "SprinklerSystem{" + "v1='" + v1 + '\'' + ", v2='" + v2 + '\'' + ", v3='" + v3 + '\'' + ", v4='" + v4 + '\'' + ", waterSource=" + waterSource + ", i=" + i + ", f=" + f + '}' + "source = " + waterSource;
    }

    public static void main(String[] args) {
        SprinklerSystem sprinklerSystem = new SprinklerSystem();
        System.out.println(sprinklerSystem);// 需要string但只有一个对象时调用toString
    }
}
