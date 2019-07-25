package com.test.llh.other;

/**
 * 一行代码求两个数的最大公约数m=nq+r
 * (m,n）的最大公约数等于（n,r)
 */
public class Gcd {
    public int gcd(int m,int n){
        return n==0?m:gcd(n,m%n );
    }
}
