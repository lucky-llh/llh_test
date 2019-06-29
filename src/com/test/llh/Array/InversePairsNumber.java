package com.test.llh.Array;

/**
 * 数组中的逆序对问题：
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairsNumber {
    /**
     * 用归并排序来统计逆序对的个数：
     * 首先把数组分为两部分，对这两部分分别排序，然后在对整体进行排序，在整体排序的过程中统计逆序对出现的次数
     * @param array
     * @return
     */
    public static int inversePairs(int [] array) {
        if(array==null||array.length==0){
            return 0;
        }
        return mergerSort(array,0,array.length-1);
    }
    public static int mergerSort(int[]arr,int left,int right){
        if(left==right){
            return 0;
        }
        int mid=(left+right)/2;
        int leftCount=mergerSort(arr,left,mid);
        int rightCount=mergerSort(arr,mid+1,right);
        return (leftCount+rightCount+merge(arr,left,mid,right))%1000000007;
    }
    public static int merge(int[]arr,int left,int mid,int right){
        int help[]=new int[right-left+1];
        int index=0;
        int num=0;
        int p1=left;
        int p2=mid+1;
        while (p1<=mid&&p2<=right){
            if(arr[p1]>arr[p2]){
                num+=(mid-p1+1);
                help[index++]=arr[p2++];
                if(num>1000000007){
                    num%=1000000007;
                }
            }else{
                help[index++]=arr[p1++];
            }
        }
        while (p1<=mid){
            help[index++]=arr[p1++];
        }
        while (p2<=right){
            help[index++]=arr[p2++];
        }
        for(int i=0;i<help.length;i++){
            arr[left++]=help[i];
        }
        return num;
    }

    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6,7,0};
        System.out.println(inversePairs(arr));
    }
}
