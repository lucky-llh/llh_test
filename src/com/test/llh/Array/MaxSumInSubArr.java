package com.test.llh.Array;

/**
 * 子数组的最大累加和问题
 */
public class MaxSumInSubArr {
    public int maxSum(int[]arr){
        if(arr==null||arr.length==0){
            return 0;
        }
        int cur=0;
        int sum=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            cur+=arr[i];
            sum=Math.max(sum,cur);
            cur=cur<0?0:cur;
        }
        return sum;
    }
}
