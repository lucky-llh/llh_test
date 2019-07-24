package com.test.llh.Array;

import java.util.HashMap;
/**
 * 没排序数组中累加和为给定值的最长子数组的长度
 */
public class MaxLengthInArr {
    public static int maxLength(int arr[],int k){
        if (arr==null||arr.length==0){
            return 0;
        }
        int sum=0;
        int len=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        for (int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            if (map.containsKey(sum-k)){
                len=Math.max(len,i-map.get(sum-k));
            }
            if (!map.containsKey(arr[i])){
                map.put(arr[i],i);
            }
        }
        return len;
    }

    /**
     * 数组中有正有负有零，求正负个数相等的最长子数组的长度
     * 可以将所有的正数设置为1，将负数设置为-1，求累加和为0的最长子数组的长度
     * @param arr
     * @return
     */
    public static int countNum(int[]arr){
        if(arr==null||arr.length==0){
            return 0;
        }
        for (int i=0;i<arr.length;i++){
            if (arr[i]>0){
                arr[i]=1;
            }
            if (arr[i]<0){
                arr[i]=-1;
            }
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,-1);
        int sum=0;
        int len=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
                len=Math.max(len,i-map.get(sum));
            }
            if (!map.containsKey(sum)){
                map.put(arr[i],i);
            }
        }
        return len;
    }

    public static void main(String[] args) {
        int[]arr={1,-1,3,3,2,-2,-1,1};
        System.out.println(maxLength(arr,0));
    }
}
