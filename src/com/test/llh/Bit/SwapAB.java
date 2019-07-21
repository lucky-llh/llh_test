package com.test.llh.Bit;

/**
 * 不使用任何变量交换两个数的值：位运算
 * a^a=0;
 * a^0=a;
 */
public class SwapAB {
    public  static void swap(int a,int b){
        a=a^b;
        b=a^b;
        a=a^b;
    }
}
