package com.test.llh.Array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 最长的可整合子数组的长度：
 * 可整合数组：排序后相邻元素差1
 * 遍历数组，判断每一个子数组的情况，若是可整合的记录长度：
 * 可整合数组的判断：数组中最大值减去最小值+1=元素个数，数组就是可整合的
 */
public class GetLongIncompactLength {
    public int getLength(int[]arr){
        if (arr==null||arr.length==0){
            return -1;
        }
        int len=0;
        int max=0;
        int min=0;
        HashSet<Integer>set=new HashSet<>();//记录是否有重复的元素
        for (int i=0;i<arr.length;i++){
            max=Integer.MIN_VALUE;
            min=Integer.MAX_VALUE;
            for (int j=i;j<arr.length;j++){
                if (set.contains(arr[i])){
                    break;
                }
                max=Math.max(max,arr[i]);
                min=Math.min(min,arr[i]);
                if (max-min==j-i){
                    len=Math.max(len,j-i+1);
                }
            }
            set.clear();
        }
        return len;
    }

    /**
     * 原始解法对每个子数组排序，然后遍历子数组校验是否超过1
     * O(n3 logn)
     * @param arr
     * @return
     */
    public int getLengthO(int[]arr){
        if (arr==null||arr.length==0){
            return -1;
        }
        int len=0;
        for (int i=0;i<arr.length;i++){
            for (int j=i;j<arr.length;j++){
                if (isIntegrated(arr,i,j)){
                    len=Math.max(len,j-i+1);
                }
            }
        }
        return len;
    }
    public boolean isIntegrated(int[]arr,int left,int right){
        int[]newArr= Arrays.copyOfRange(arr,left,right+1);
        Arrays.sort(newArr);
        for (int i=1;i<newArr.length;i++){
            if (newArr[i-1]!=newArr[i]-1){
                return false;
            }
        }
        return true;
    }
}
