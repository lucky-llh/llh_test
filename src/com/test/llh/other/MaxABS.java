package com.test.llh.other;

/**
 * 左边最大值减去右边最大值之差的绝对值最大：
 * 遍历一遍数组，找到数组的最大值，然后比较最左边以及最右边结点哪个更小，把他单独划分为一个区域，然后用最大值相减就是绝对值最大的情况
 */
public class MaxABS {
    public int maxAbs(int[]arr){
        if (arr==null||arr.length==0){
            return -1;
        }
        int max=Integer.MIN_VALUE;
        for (int i=0;i<arr.length;i++){
            max=Math.max(arr[i],max);
        }
        return max-Math.min(arr[0],arr[arr.length-1]);
    }
}
