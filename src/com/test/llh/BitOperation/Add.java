package com.test.llh.BitOperation;

/**
 *
 */
public class Add {
    /**
     * 由十进制运算可得，两个数相加，可以转换为进位结果+不进位结果
     * 二进制也可由此进行运算，当进位结果为0时终止
     * @param num1
     * @param num2
     * @return
     */
    public static int addSum(int num1,int num2){
        while (num2!=0){
            //无进位运算，相当于异或运算，即查看两个数哪些二进制位只有一个为1
            int sum=num1^num2;
            //进位运算，即查看两个数哪些二进制位都为1，需进位，往左移1位
            int carray=(num1&num2)<<1;
            num1=sum;
            num2=carray;
        }
        return num1;
    }

    public static void main(String[] args) {
        int num1=1;
        int num2=2;
        System.out.println(addSum(num1,num2));
    }
}
