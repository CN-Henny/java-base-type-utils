package com.example.demo;


import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DemoApplication {

    public static void main(String[] args) {

        Integer aasd = 32767;
        Double a = 1234567890123.123456789456;
        Integer b = 0;
//a.toInteger();
        System.out.println(a.decimalsLength());
System.out.println(a.roundHalfUp(2));
        System.out.println(a.roundHalfDown(2));
        System.out.println(a.roundUp(2).nousedF_E());
        System.out.println(a.roundDown(2));
        //Date c = new Date();
//a.toInteger();
        //a.toString().toBigDecimal();

    }

}
