package com.test.llh.Array;

/**
 * 不重复打印数组中相加和为给定值的所有二元组和三元组
 */
public class PrintUniquePair {
    /**
     * 因为是排序数组，所以可以用左右加比
     * @param arr
     * @param k
     */
    public void printUniquePair(int[]arr,int k){
        if (arr==null||arr.length==0){
            return;
        }
        int left=0;
        int right=arr.length-1;
        while (left<right){
            if (arr[left]+arr[right]<k){
                left++;
            }else if (arr[left]+arr[right]>k){
                right--;
            }else{
                if (left==0||arr[left-1]!=arr[left]){
                    System.out.println(arr[left]+","+arr[right]);
                    left++;
                    right--;
                }
            }
        }
    }
    public void printUniqueTriad(int[]arr,int k){
        if (arr==null||arr.length==0){
            return;
        }
        for (int i=0;i<arr.length;i++){
            printRest(arr,i,i+1,arr.length-1,k-arr[i]);
        }
    }
    public void printRest(int[]arr,int f,int l,int r,int k){
        while (l<r){
            if (arr[l]+arr[r]<k){
                l++;
            }else if (arr[l]+arr[k]>k){
                r--;
            }else {
                if (l==f+1||arr[l-1]!=arr[l]){
                    System.out.println(arr[f]+","+arr[l]+","+arr[r]);
                    l++;
                    r--;
                }
            }
        }
    }
}
