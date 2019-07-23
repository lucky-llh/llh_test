package com.test.llh.Array;

/**
 * 在行列都排序的数组中找数：
 * 从左到右递增，从上到下递增
 */
public class IsContainsInOrderMatrix {
    public boolean isContains(int[][]arr,int key){
        if (arr==null||arr[0]==null||arr.length==0||arr[0].length==0){
            return false;
        }
        int row=0;
        int col=arr[0].length-1;
        while (row<arr.length&&col>-1){
            if (arr[row][col]==key){
                return true;
            }else if (arr[row][col]>key){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
