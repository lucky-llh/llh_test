package com.test.llh.String;
/**
 * 判断字符串中所有的字符是否都只出现一次：
 * （1）：实现时间复杂度O(N）的方法
 * （2）：在保证额外空间为O(1）的情况下，时间复杂度尽量低
 */
public class IsUniqueChar {
    public boolean isUnique1(char[] str){
        if (str==null||str.length==0){
            return true;
        }
        boolean[]arr=new boolean[256];
        for (int i=0;i<str.length;i++){
            if(arr[i]){
                return false;
            }
            arr[i]=true;
        }
        return true;
    }

    /**
     * 2：使用堆排序现将数组排序，排序后相同的字符肯定连续出现，在判断
     * @param arr
     * @return
     */
    public boolean isUnique2(char[]arr){
        if (arr==null||arr.length==0){
            return true;
        }
        heapsort(arr);
        for (int i=1;i<arr.length;i++){
            if (arr[i]==arr[i-1]){
                return false;
            }
        }
        return true;
    }
    public void heapsort(char[]arr){
        for(int i=0;i<arr.length;i++){
            heapInsert(arr,i);//建堆
        }
        for(int i=arr.length-1;i!=-1;i--){
            swap(arr,i,0);//最后一个元素与堆顶进行交换
            heapify(arr,i,0);//排序
        }
    }
    public void heapInsert(char[]arr,int index){
        int parent=0;
        while (index!=0){
            parent=(index-1)/2;
            if (arr[parent]<arr[index]){
                swap(arr,parent,index);
                index=parent;
            }else{
                break;
            }
        }
    }
    public void heapify(char[]arr,int heapsize,int index){
        int left=index*2+1;
        int right=index*2+2;
        int largest=index;
        while (left<heapsize){
            if (arr[left]>arr[index]){
                largest=left;
            }
            if (right<heapsize&&arr[right]>arr[index]){
                largest=right;
            }
            if (largest!=index){
                swap(arr,largest,index);
            }else {
                break;
            }
            index=largest;
            left=2*index+1;
            right=2*index+2;
        }
    }
    public void swap(char[]arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
