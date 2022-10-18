package com.example.demo;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DemoApplication {

    public static void main(String[] args) {

        Integer aasd = 32767;
        Double a = 1234567890123.123456789456;
        BigDecimal c = new BigDecimal("0.0000000000000000000000000");
        Integer b = 0;
        Date aaa;
//a.toInteger();
        System.out.println(a.customDecimalsLength());
System.out.println(a.customRoundHalfUp(2));
        System.out.println(a.customRoundHalfDown(2));
        System.out.println(a.customRoundUp(2).customNousedF_E());
        System.out.println(a.customRoundDown(2));
        System.out.println(c);
        System.out.println(c);
        //Date c = new Date();
//a.toInteger();
        //a.toString().toBigDecimal();

    }

}
