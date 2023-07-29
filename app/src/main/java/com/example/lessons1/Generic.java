package com.example.lessons1;

import java.util.ArrayList;
import java.util.List;

public class Generic {
    public static void dod(){
        List<Essen> a = new ArrayList<>();
        addCats(a);
    }

    public static void addCats(List<? super Animal> animals) {
        animals.add((Object)new Essen());
    }
}
class Essen{}
class Animal extends Essen{}
class Cat extends Animal{}
