package com.test.llh.BitOperation;

/**
 * 数组中只出现一次的数字：
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字
 */
public class FindNumsAppearOnce {
    /**
     * 异或运算性质：n^n=0,n^0=n
     * 可以使用异或运算，遍历数组最后得到的结果就是只出现一次的两个数得到的结果，结果肯定不为0，则说明至少有一位为1，所以根据某一位是否为1，将其分为两部分，最后在进行异或运算，
     * 最终得到两个只出现一次的数字
     * @param arr
     * @param num1
     * @param num2
     */
    public static void findNumsOfOnce(int[]arr,int num1[],int num2[]){
        int eone=0;
        for(int num:arr){
            eone^=num;
        }
        //找到最低位为1的位置，进行区分
        int rightone=eone&(~eone+1);
        for(int cur:arr){
            if((rightone&cur)!=0){
                num1[0]^=cur;
            }else{
                num2[0]^=cur;
            }
        }
        System.out.println(num1[0]+" "+num2[0]);
    }

    public static void main(String[] args) {
        int[]arr={1,2,2,3,3,4,4,5};
        int[]num1=new int[1];
        int[]num2=new int[1];
        findNumsOfOnce(arr,num1,num2);
    }
}
