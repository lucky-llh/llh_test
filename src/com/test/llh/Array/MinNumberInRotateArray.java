package com.test.llh.Array;

public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int[]arr){
        //1.数组空校验
        if(arr==null||arr.length==0){
            return 0;
        }
        //2.用二分查找提高查找效率
        int left=0;
        int right=arr.length-1;
        while (left<right){
            if (left==right-1){
                break;
            }
            //未旋转
            if(arr[left]<arr[right]){
                return arr[left];
            }
            int mid=(left+right)/2;
            //说明左边递减，右边递增，最小值应该出现在左边
            if (arr[left]>arr[mid]){
                right=mid;
                continue;
            }
            //说明左边递增，右边递减，最小值应该出现在右边
            if (arr[left]<arr[mid]){
                left=mid;
                continue;
            }

            //如果left，mid,right的值相等，可以继续使用二分查找，也可以从头开始遍历
            while (left<mid){
                if (arr[left]==arr[mid]){
                    left++;
                }else if (arr[left]<arr[mid]){
                    return arr[left];
                }else{
                    right=mid;
                    continue;
                }
            }
        }
        return Math.min(arr[left],arr[right]);
    }

    public static void main(String[] args) {
        int []arr={3,4,5,1,2};
        System.out.println(minNumberInRotateArray(arr));
    }
}
