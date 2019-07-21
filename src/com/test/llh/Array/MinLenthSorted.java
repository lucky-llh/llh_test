package com.test.llh.Array;

/**
 * 需要排序的最短子数组的长度
 */
public class MinLenthSorted {
    /**
     * 从左往右遍历一遍，用变量max记录左边出现的最大值，如果arr[i]<max说明要是整体有序，需要将max移动到arr[i]的右边，用变量nomaxindex记录这样的位置
     * 同理从右往左遍历一遍，用变量min记录右边出现的最小值，如果arr[i]》min,要整体有序需要调整位置，用变量nominindex记录这样的地址
     * @param arr
     * @return
     */
    public static int minlength(int[]arr){
        if (arr==null||arr.length==0){
            return 0;
        }
        int min=arr[arr.length-1];
        int noMinIndex=-1;
        for(int i=arr.length-2;i!=-1;i--){
            if(arr[i]>min){
                noMinIndex=i;
            }else{
                min=Math.min(min,arr[i]);
            }
        }
        //说明整体有序从右往左不升序
        if (noMinIndex==-1){
            return 0;
        }
        int max=arr[0];
        int noMaxIndex=-1;
        for(int i=1;i<arr.length;i++){
            if (arr[i]<max){
                noMaxIndex=i;
            }else{
                max=Math.max(max,arr[i]);
            }
        }
        return noMaxIndex-noMinIndex+1;
    }
}
