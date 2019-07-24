package com.test.llh.Array;

/**
 * 奇数下标都是奇数或者偶数下标都是偶数
 */
public class ModifySort {
    /**
     * 定义even和odd为数组最左边及最右边的下标，不断比表数组最后一个数，如果是奇数，就与奇数位置交换，如果是偶数就与偶数位置交换
     * @param arr
     */
    public void modify(int[]arr){
        if (arr==null||arr.length==0){
            return;
        }
        int even=0;
        int odd=1;
        int end=arr.length-1;
        while (even<=end&&odd<=end){
            if((arr[end]&1)==0){
                swap(arr,end,even);
                even+=2;
            }else{
                swap(arr,end,odd);
                odd+=2;
            }
        }
    }
    public void swap(int[]arr,int left,int right){
        arr[left]=arr[left]^arr[right];
        arr[right]=arr[left]^arr[right];
        arr[left]=arr[left]^arr[right];
    }
}
