package com.test.llh.Array;

/**
 * 子数组的最大累乘积：
 * 应该求以每个位置结尾的情况下最大的累乘积：
 * 有三种情况：
 * 1.前面一个数的最大值*该位置的值
 * 2.前面一个数的最小值*该位置的值
 * 3.当前位置的值自己
 * 每次比较这三个数，最大的就是该位置最大值，最小的就是该位置最小值，以此类推
 */
public class MaxProduct {
    public double maxProduct(double[]arr){
        if (arr==null||arr.length==0){
            return 0;
        }
        double max=arr[0];
        double min=arr[0];
        double res=arr[0];
        double maxEnd=0;
        double minEnd=0;
        for (int i=1;i<arr.length;i++){
            maxEnd=max*arr[i];
            minEnd=min*arr[i];
            max=Math.max(Math.max(maxEnd,minEnd),max);
            min=Math.min(Math.min(maxEnd,minEnd),min);
            res=Math.max(res,max);
        }
        return max;
    }
}
