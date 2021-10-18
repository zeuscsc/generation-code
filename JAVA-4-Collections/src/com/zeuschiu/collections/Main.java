package com.zeuschiu.collections;

import java.util.ArrayList;
import java.util.HashMap;

class Person{
    public String name;
}
public class Main {
    public static ArrayList<Person> arrayList=new ArrayList<Person>();
    public static ArrayList<Integer> integerArrayList=new ArrayList<Integer>();
    public static float[] numbers={1,2,3,4,5};
    public static Person[] persons=new Person[5];
    public static HashMap<Person,Integer> hashMap =new HashMap<Person, Integer>();

    public static void main(String[] args) {
        Person a=new Person();
        Person b=new Person();
        a.name="a";
        b.name="b";
        float[] copy=numbers;
        numbers=new float[100];//don't could somehow for this case
        //copy=0xAD
        //number=0xAE
        for(int i=0;i<copy.length;i++){
            numbers[i]=copy[i];
        }
        arrayList.add(new Person());
        arrayList.add(new Person());
        arrayList.get(0).name="1";
        arrayList.get(1).name="2";
        arrayList.set(0,new Person());
        arrayList.remove(0);
        arrayList.add(1,new Person());
        boolean contains=arrayList.contains(new Person());
        hashMap.put(a,1);
        hashMap.put(b,2);
        Integer i1= hashMap.get(a);
        Integer i2= hashMap.get(b);
        hashMap.keySet().toArray();
    }
}
