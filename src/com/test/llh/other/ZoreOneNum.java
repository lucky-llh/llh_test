package com.test.llh.other;

/**
 * 给定一个非负整数N,返回N!结果的末尾为0的数
 */
public class ZoreOneNum {
    /**
     * 应该统计n个数中含有因子5的个数，因为每一个因子5都可以与2相乘得到一个0
     * @param n
     * @return
     */
    public int zoreNum(int n){
        if(n<0){
            return 0;
        }
        int res=0;
        int cur=0;
        for (int i=5;i<n+1;i++){
            cur=i;
            while (cur%5==0){
                res++;
                cur/=5;
            }
        }
        return res;
    }

    /**
     * 非负整数N,N！中最低位1在哪个位置，因该统计因子2出现的次数
     * @param n
     * @return
     */
    public int rightOne(int n){
        if(n<0){
            return -1;
        }
        int res=0;
        while (n!=0){
            n>>>=1;
            res+=n;
        }
        return res;
    }
}
