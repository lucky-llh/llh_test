package com.test.llh.Recursion;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class JumpFloor {
    //递归
    public static int jumpFloorByRecur(int n){
        if(n==1||n==2){
            return n;
        }
        return jumpFloorByRecur(n-1)+jumpFloorByRecur(n-2);
    }
    //非递归
    public static int jumpFloor(int n){
        if(n==1||n==2){
            return n;
        }
        int temp=0;
        int pre=1;
        int res=2;
        for(int i=2;i<n;i++){
            temp=res;
            res=res+pre;
            pre=temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(jumpFloor(n)+"========"+jumpFloorByRecur(n));
    }
}
