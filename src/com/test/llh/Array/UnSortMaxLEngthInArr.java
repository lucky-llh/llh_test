package com.test.llh.Array;

/**
 * 未排序数组中累加和小于等于给定值的最长子数组的长度
 */
public class UnSortMaxLEngthInArr {
    /**
     * 求某个位置结尾的情况下，累加和小于等于某个值的最长长度，
     * 假设0..i上累加和为sum,只需直到在0..i某一位置上如果有一个位置j累加和大于等于sum-k,则在j..i上的累加和就是小于等于k的
     * 所以可以用一个辅助数组help记录每个位置左边的累加和，然后去查找
     * @param arr
     * @param k
     * @return
     */
    public static int maxLength(int[]arr,int k){
        if (arr==null||arr.length==0){
            return 0;
        }
        int[]help=new int[arr.length+1];
        int sum=0;
        help[0]=0;
        for (int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            help[i+1]=Math.max(sum,help[i]);
        }
        sum=0;
        int pre=0;
        int len=0;
        int res=0;
        for (int i=0;i<arr.length;i++){
            sum+=arr[i];
            pre=getLessIndex(help,sum-k);
            len=pre==-1?0:i-pre+1;
            res=Math.max(res,len);
        }
        return res;
    }
    public static int getLessIndex(int[]arr,int sum){
        int left=0;
        int right=arr.length-1;
        int mid=0;
        int res=0;
        while (left<=right){
            mid=(left+right)/2;
            if (arr[mid]>=sum){
                res=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[]arr={3,-2,-4,0,6};
        int k=2;
        System.out.println(maxLength(arr,k));
    }
}
