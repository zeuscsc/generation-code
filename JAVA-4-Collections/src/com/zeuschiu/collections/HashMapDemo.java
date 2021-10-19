package com.zeuschiu.collections;

import java.util.ArrayList;
import java.util.HashMap;

class Hero{
    public String name;
    public Integer goodThingsCount;

    public Hero(String name){
        this.name=name;
        this.goodThingsCount=1;
    }
    public String toString(){
        return name;
    }
}
class Villain {
    public String name;
    public Integer badThingsCount;
    public Villain(String name){
        this.name=name;
    }
    public String toString(){
        return name;
    }
}
public class HashMapDemo {
    public static void Demo(){
        Hero ironMan=new Hero("Iron Man");
        ironMan.goodThingsCount=100;
        Hero ironManSuit=new Hero("Iron Man");
//        ironMan2=ironMan;
        Hero onePunchMan=new Hero("One Punch Man");
        Villain thanos =new Villain("Thanos");
        Villain loki =new Villain("Loki");
        HashMap<Hero, Villain> map=new HashMap<Hero, Villain>();
        map.put(ironMan,thanos);
        map.put(ironManSuit,loki);
        map.put(onePunchMan,thanos);
        Villain against=map.get(ironMan);
        System.out.println(against);
        HashMap<String,Villain> stringVillainHashMap=new HashMap<String, Villain>();
        stringVillainHashMap.put(ironMan.toString(),thanos);
        stringVillainHashMap.put(ironManSuit.toString(),thanos);
        stringVillainHashMap.put(onePunchMan.toString(),thanos);

        ArrayList<Hero> heroes=new ArrayList<Hero>();
        heroes.add(ironMan);
        heroes.add(ironManSuit);
        heroes.add(onePunchMan);
        ArrayList<Villain> villains=new ArrayList<Villain>();
        villains.add(thanos);
        villains.add(loki);
        ArrayList<Integer> heroesVsVillains=new ArrayList<Integer>();
        heroesVsVillains.add(0);
        heroesVsVillains.add(1);
        heroesVsVillains.add(0);

    }
}
