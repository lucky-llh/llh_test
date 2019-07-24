package com.test.llh.Array;

/**
 * 计算数组中的小和：
 * 每个位置左边比他小的数的累加和
 */
public class GetMinSum {
    /**
     * 使用归并算法求解，每一次进行归并时都计算小和
     * @param arr
     * @return
     */
    public static int minSum(int[]arr){
        if (arr==null||arr.length==0){
            return 0;
        }
        return mergeSort(arr,0,arr.length-1);
    }
    public static int mergeSort(int[]arr,int left,int right){
        if (left==right){
            return 0;
        }
        int mid=(left+right)/2;
        return mergeSort(arr,left,mid)+mergeSort(arr,mid+1,right)+merge(arr,left,mid,right);
    }
    public static int merge(int[]arr,int left,int mid,int right){
        int[]help=new int[right-left+1];
        int index=0;
        int l=left;
        int r=mid+1;
        int sum=0;
        while (l<=mid&&r<=right){
            if (arr[l]<=arr[r]){
                sum+=arr[l]*(right-r+1);
                help[index++]=arr[l++];
            }else{
                help[index++]=arr[r++];
            }
        }
        while (l<mid+1){
            help[index++]=arr[l++];
        }
        while (r<right+1){
            help[index++]=arr[r++];
        }
        for(int i=0;i<help.length;i++) {
            arr[left++] = help[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[]arr={1,3,5,2,4,6};
        System.out.println(minSum(arr));
    }
}
