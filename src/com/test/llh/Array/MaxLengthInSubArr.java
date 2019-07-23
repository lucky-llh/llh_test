package com.test.llh.Array;

/**
 * 未排序正数数组中累加和为给定值的最长子数组长度
 */
public class MaxLengthInSubArr {
    public int maxLength(int[]arr,int aim){
        if (arr==null||arr.length==0){
            return 0;
        }
        int len=0;
        int left=0;
        int right=0;
        int sum=0;
        while (right<arr.length){
            if (sum==aim){
                len=Math.max(len,right-left+1);
                sum-=arr[left++];
            }else if (sum<aim){
                right++;
                if(right==arr.length){
                    break;
                }
                sum+=arr[right];
            }else{
                sum-=arr[left++];
            }
        }
        return len;
    }
}
