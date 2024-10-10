package com.chapter15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Frob{}
class Fnorkle{}
class Quark<Q>{}
class Particle<POSITION, MOMENTUM>{}
public class LostInformation {
    public static void main(String[] args) {
        ArrayList<Frob> list = new ArrayList<>();
        HashMap<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> particle = new Particle<>();

        ArrayList<Integer> li = new ArrayList<>();

        System.out.println(Arrays.toString(li.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));
        System.out.println(Arrays.toString(particle.getClass().getTypeParameters()));
    }
}
