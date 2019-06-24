package com.test.llh.Recursion;

/**
 * 斐波那契数列1,1,2,3,5,8,13
 */
public class Fibonacci {
    //递归
    public static int fibonacciByRecur(int n){
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        return fibonacciByRecur(n-1)+fibonacciByRecur(n-2);
    }
    //非递归
    public static int fibonacci(int n){
        if(n==0){
            return 0;
        }
        if (n==1||n==2){
            return 1;
        }
        int temp=0;
        int res=1;
        int pre=1;
        for(int i=2;i<n;i++){
            temp=res;
            res=res+pre;
            pre=temp;
        }
        return res;
    }

    public static void main(String[] args) {
        int n=8;
        System.out.println(fibonacci(n)+"========"+fibonacciByRecur(n));
    }
}
