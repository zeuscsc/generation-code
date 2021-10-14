package com.zeuschiu.types;


public class Main {
    public static void main(String[] args) {
        Circle c1=new Circle(Float.parseFloat(args[0]));
        Circle c2=new Circle(Float.parseFloat(args[1]));
        System.out.println(c1.toString());
        System.out.println(c2.toString());
    }

    //Stack
    //0x00 --> hi
//    public static void main(String[] args) {
////        String i1="hi";//i1*|Stream=0x00
////        String i2="hi";//i2*|Stream=0x00
////        String a1 =new String("hi");//a1*=0x01|Stream=0x00
////        String a2 =new String("hi");//a1*=0x02|Stream=0x00
////        a1=a2;//a1*=0x02
////        System.out.println((i1==i2));
////        System.out.println((a1==a2));
////        System.out.println((a1.equals(a2)));
////        System.out.println(("hi"=="hi"));
////        UserProfile profile1=new UserProfile();
////        UserProfile profile2=new UserProfile();
//    }
}