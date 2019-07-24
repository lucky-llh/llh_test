package com.test.llh.Array;

/**
 * 自然数数组排序：
 * 长度为N的数组，存放的自然数为1-N,实现对自然数排序
 * 排序后i位置存放i+1的数
 */
public class SorNumber {
    public void sort(int []arr){
        if (arr==null||arr.length==0){
            return;
        }
        int temp=0;
        for (int i=0;i<arr.length;i++){
            while (arr[i]!=i+1){
                temp=arr[arr[i]-1];
                arr[arr[i]-1]=arr[i];
                arr[i]=temp;
            }
        }
    }
}
