package com.test.llh.Array;

import java.util.ArrayList;

/**
 * 和为s的两个数字：输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class FindNumbersWithSum {
    /**
     * 因为数组是有序的，所以可以使用左右加逼的方法进行运算
     * @param arr
     * @param sum
     * @return
     */
    public static ArrayList<Integer>findNumWithSum(int[]arr,int sum){
        ArrayList<Integer>list=new ArrayList<>();
        if (arr==null||arr.length==0){
            return list;
        }
        int left=0;
        int right=arr.length-1;
        while (left<right){
            if (arr[left]+arr[right]==sum){
                list.add(arr[left]);
                list.add(arr[right]);
                break;
            }else if (arr[left]+arr[right]<sum){
                left++;
            }else {
                right--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7,8,9,10};
        int sum=11;
        findNumWithSum(arr,sum).stream().forEach(System.out::println);

    }
}
