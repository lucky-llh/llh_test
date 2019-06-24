package com.test.llh.BitOperation;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Power {
    public static double power(double base,int exponent){
       int n=0;
       double res=1.0,cur=base;
       if(exponent>0){
           n=exponent;
       }else if (exponent<0){
           if(base!=0){
               n=-exponent;
           }
       }else {
           return 1;//任何数的0次方都为1
       }

       while (n!=0){
           if((n&1)==1){
               res=res*cur;
           }
           cur=cur*cur;
           n>>=1;//右移一位
       }
       return exponent>0?res:1/res;
    }

    public static void main(String[] args) {
        System.out.println(power(2.0,4));
    }
}
