package com.zeuschiu.collections.oop;

import java.math.BigDecimal;

public class BigDecimalDemo {

    public static void main(String[] args) {
        double d=10001231231231230.0011214211231231231121;
        //d=1x10^16
        BigDecimal decimal=new BigDecimal("10001231231231230.0011214211231231231121");
        BigDecimal decimal2=decimal.add(new BigDecimal("1"));
    }
}
