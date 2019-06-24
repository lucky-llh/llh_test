package com.test.llh.BitOperation;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class NumberOfOne {
    public static int numberOfOne(int n){
        int oneNumber=0;
        while (n!=0){
            oneNumber++;
            n=n&(n-1);
        }
        return oneNumber;
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(numberOfOne(n));
    }
}
