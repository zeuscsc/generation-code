package com.zeuschiu.collections.oop;

class SqrtException extends RuntimeException {
    public SqrtException(String msg){
        super(msg);
    }
}
public class TryCatchDemo {
    public static double sqrt(double number) {
        if(number<0){
            throw new SqrtException("Input should be positive number.");
        }
        return Math.sqrt(number);
    }

    public static void main(String[] args) {
        double ans;
//        ans=sqrt(-2);
        try {
            ans=sqrt(4);
            System.out.println(ans);
        } catch (Exception e){
            System.out.println("Input is negative number, answer will be -1.");
            ans=-1;
            System.out.println(ans);
        }
        System.out.println(ans);
    }
}
