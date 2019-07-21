package com.test.llh.Array;

import java.util.Arrays;

public class MinKNum {
    /**
     * 建立大跟堆求最小的k个数
     * @param arr
     * @param k
     * @return
     */
    public static int[]getKMinNum(int[]arr,int k){
        if (arr==null||arr.length==0||k<0){
            return null;
        }
        int res[]=new int[k];
        for (int i=0;i!=k;i++){
            heapInsert(res,arr[i],i);
        }
        for(int i=k;i!=arr.length;i++){
            //比堆顶元素小，交换，调整堆
            if(arr[i]<res[0]){
                res[0]=arr[i];
                heapify(res,0,k);
            }
        }
        return res;
    }
    public static void heapInsert(int[]arr,int value,int index){
        arr[index]=value;
        int parent=0;
        while (index!=0){
            parent=(index-1)/2;
            if(arr[parent]<arr[index]){
                swap(arr,index,parent);
                index=parent;
            }else{
                break;
            }

        }
    }
    public static void heapify(int[]arr,int index,int heapSize){
        int left=2*index+1;
        int right=2*index+2;
        int largest=index;
        while (left<heapSize){
            if(arr[left]>arr[largest]){
                largest=left;
            }else if (right<heapSize&&arr[right]>arr[largest]){
                largest=right;
            }
            if (largest!=index){
                swap(arr,largest,index);
            }else{
                break;
            }
            index=largest;
            left=2*index+1;
            right=2*index+2;
        }
    }
    public static void swap(int[]arr,int i,int j){
        arr[i]=arr[i]^arr[j];
        arr[j]=arr[i]^arr[j];
        arr[i]=arr[i]^arr[j];
    }

    /**
     * 获取最大的k个数
     * @param arr
     * @param k
     * @return
     */
    public static int[]getMaxNum(int[]arr,int k){
        if (k<1||k>arr.length){
            return null;
        }
        int[]res=new int[k];
        for (int i=0;i!=k;i++){
            heapInsertBig(res,arr[i],i);
        }
        for(int i=k;i!=arr.length;i++){
            if(arr[i]>res[0]){
                res[0]=arr[i];
                heapifyBig(res,0,k);
            }
        }
        return res;
    }
    public static void heapInsertBig(int[]arr,int value,int index){
        arr[index]=value;
        int parent=0;
        while (index!=0){
            parent=(index-1)/2;
            if(arr[parent]>arr[index]){
                swap(arr,parent,index);
                index=parent;
            }else{
                break;
            }
        }
    }
    public static void heapifyBig(int[]arr,int index,int heapSize){
        int left=2*index+1;
        int right=2*index+2;
        int smallest=index;
        while (left<heapSize){
            if (arr[left]<arr[index]){
                smallest=left;
            }else if (right<heapSize&&arr[right]<arr[smallest]){
                smallest=right;
            }
            if (smallest!=index){
                swap(arr,smallest,index);
            }else{
                break;
            }
            index=smallest;
            left=2*index+1;
            right=2*index+2;
        }
    }

    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7};
        int k=3;
        int[]res=getKMinNum(arr,k);
        int[]maxs=getMaxNum(arr,k);
        Arrays.stream(res).forEach(System.out::print);
        System.out.println("=====");
        Arrays.stream(maxs).forEach(System.out::print);
    }
}
