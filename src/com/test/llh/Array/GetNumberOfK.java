package com.test.llh.Array;

/**
 * 统计一个数字在排序数组中出现的次数
 */
public class GetNumberOfK {
    /**
     * 使用二分查找统计该数在数组中出现的最左边的索引以及最有边的索引
     * @param array
     * @param k
     * @return
     */
    public static int getNumberOfK(int [] array , int k) {
        if(array==null||array.length==0){
            return 0;
        }
        int leftIndex=getLeftIndex(array,0,array.length-1,k);
        int rightIndex=getRightIndex(array,0,array.length-1,k);
        if(leftIndex==-1||rightIndex==-1){
            return 0;
        }
        return rightIndex-leftIndex+1;
    }
    public static int getLeftIndex(int[]arr,int left,int right,int k){
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]>k){
                right=mid-1;
            }else if(arr[mid]<k){
                left=mid+1;
            }else {
                if(mid==0||(mid>0&&arr[mid-1]!=k)){
                    return mid;
                }else{
                    right=mid-1;
                }
            }
        }
        return -1;
    }
    public static int getRightIndex(int[]arr,int left,int right,int k){
        while (left<=right){
            int mid=(left+right)/2;
            if(arr[mid]>k){
                right=mid-1;
            }else if(arr[mid]<k){
                left=mid+1;
            }else{
                if(mid==arr.length-1||(mid<arr.length-1&&arr[mid+1]!=k)){
                    return mid;
                }else{
                    left=mid+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[]arr={1,2,3,3,3,3,4,5,6,7,8,9};
        System.out.println(getNumberOfK(arr,3));
    }
}
