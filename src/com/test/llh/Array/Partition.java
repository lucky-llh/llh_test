package com.test.llh.Array;

/**
 * 数组的partition:
 * 给定一个数组，只含有三种元素0,1,2，实现arr排序
 * 用变量left记录左半区最右的位置，左半区元素为0
 * 用index记录中间位置，left+1..index上值为1
 * 用right记录右半区开始位置right..n-1都是2
 * 初始值，left=-1,right=arr.length;
 * index=0;
 */
public class Partition {
    public void sort(int[]arr){
        if (arr==null||arr.length==0){
            return;
        }
        int left=-1;
        int index=0;
        int right=arr.length;
        while (index!=right){
            if (arr[index]==0){
                swap(arr,index++,++left);
            }else if (arr[index]==2){
                swap(arr,index,--right);
            }else{
                index++;
            }
        }
    }
    public void swap(int[]arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }
}
