package com.test.llh.Array;

/**
 * 在数组中找到局部最小值的位置
 * 若数组只有一个元素，最小值位置为arr[0]
 * 若arr[0]<arr[1]那莫arr[0]就是局部最小值
 * 若arr[n-1]<arr[n-2]那莫arr[n-1]就是局部最小值
 * 其他情况：
 * 若arr[i]<arr[i-1],arr[i+1]>arr[i],那莫arr[i]就是局部最小值
 */
public class FindIndex {
    public int minIdex(int[]arr){
        if (arr==null||arr.length==0){
            return -1;
        }
        if (arr.length==1||arr[0]<arr[1]){
            return 0;
        }
        if (arr[arr.length-1]<arr[arr.length-2]){
            return arr.length-1;
        }
        int left=1;
        int right=arr.length-2;
        int mid=0;
        while (left<right){
            mid=(left+right)/2;
            if (arr[mid]>arr[mid-1]){
                right=mid-1;
            }else if (arr[mid]<arr[mid+1]){
                left=mid+1;
            }else {
                return mid;
            }
        }
        return left;
    }
}
