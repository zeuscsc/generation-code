package com.zeuschiu.collections.oop;

import java.math.BigInteger;

public class Factorial {
    //3!=3x2x1
    //f(n)=f(n-1)xn
    //3!=3xf(3-1)
    //  =2xf(2-1)
    //f(1)=1
    //  =2x1
    //  =3x2
    //3!=6
    public static BigInteger recursively(Integer integer){
        if(integer==1||integer==0)
            return new BigInteger("1");
        return recursively(integer-1).multiply(new BigInteger(integer.toString()));
    }
    public static BigInteger iteratively(Integer integer){
        BigInteger ans=new BigInteger("1");
        for(int i=2;i<=integer;i++){
            ans=ans.multiply(new BigInteger(Integer.toString(i)));
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Factorial.iteratively(10).toString());
        System.out.println(Factorial.iteratively(10000).toString());
    }
}
