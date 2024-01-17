package com.example;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Decimal {
    public static void main(String[] args){
       // BigDecimal amt =  BigDecimal.valueOf(5.001);
        BigDecimal amt  = BigDecimal.valueOf(0);
        DecimalFormat amountFormat = new DecimalFormat("#,##0.00");

        String value = amountFormat.format(amt);

     /*   if (BigDecimal.ZERO.compareTo(amt) != 0){
           System.out.println("Not Equal zero");
        }else {
            System.out.println("Equal zero");
        }*/
        if ( !value.equals("0.00")){
            System.out.println("Not Equal zero");
        }else {
            System.out.println("Equal zero");
        }
    }
}
