package com.test.llh.Array;

/**
 * 求连续子数组的最大和
 */
public class FindGreatestSumOfSubArray {
    /**
     * 用一个变量cur记录当前的累加和，当cur<0时，就将cur归0，>0时继续累加；用变量max记录结果的最大值
     * @param array
     * @return
     */
    public static int findGreatestSumOfSubArray(int[] array) {
        if(array==null||array.length==0){
            return 0;
        }
        int cur=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            cur+=array[i];
            max=Math.max(max,cur);
            cur=cur<0?0:cur;
        }
        return max;
    }

    public static void main(String[] args) {
        int[]arr={6,-3,-2,7,-15,1,2,2};
        System.out.println(findGreatestSumOfSubArray(arr));
    }
}
