package com.test.llh.Heap;

import java.util.ArrayList;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 利用堆排序
 */
public class GetLeastNumbers {

    public static ArrayList<Integer> getLeastNumbers(int [] input, int k) {
        ArrayList<Integer>list=new ArrayList<>();
        if(input==null||input.length==0||k>input.length||k==0){
            return list;
        }
        int[]res=new int[k];
        //建立包含k个元素的大根堆
        for(int i=0;i<k;i++){
            heapInsert(res,input[i],i);
        }
        //调整堆
        for(int i=k;i<input.length;i++){
            if(res[0]>input[i]){
                res[0]=input[i];
            }
            heapFiy(res,0,k);
        }
        for(int num:res){
            list.add(num);
        }
        return list;
    }
    public static void heapInsert(int[]arr,int value,int index){
        arr[index]=value;
        while (index!=0){
            int parent=(index-1)/2;
            if(arr[parent]<arr[index]){
                swap(arr,parent,index);
            }
            index=parent;
        }
    }
    public static void heapFiy(int[]arr,int index,int heapSize){
        int left=2*index+1;
        int right=2*index+2;
        int largest=index;
        while (left<heapSize){
            if(arr[largest]<arr[left]){
                    largest=left;
            }
            if(right<heapSize&&arr[right]>arr[largest]){
                largest=right;
            }
            if(index==largest){
                break;
            }else{
                swap(arr,index,largest);
            }
            index=largest;
            left=2*index+1;
            right=2*index+2;
        }
    }
    public static void swap(int[]arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[]arr={4,5,1,6,2,7,3,8};
        int k=4;
        ArrayList<Integer>list=getLeastNumbers(arr,k);
        list.stream().forEach(System.out::println);
    }
}
