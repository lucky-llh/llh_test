package com.test.llh.Recur;

import java.util.Arrays;

/**
 * 最长递增子序列
 */
public class GenerateLIST {
    /**
     * 首先生成dp数组，dp[i]表示以i结尾的情况下，arr[0..i]中最长递增子序列的长度
     * @param arr
     * @return
     */
    public static int []generate(int[]arr){
        if (arr==null||arr.length==0){
            return null;
        }
        int []dp=getDp(arr);
        int len=0;
        int index=0;
        for (int i=0;i<dp.length;i++){
            if (dp[i]>len){
                len=dp[i];
                index=i;
            }
        }
        int[]res=new int[len];
        res[--len]=arr[index];
        for (int i=index;i>=0;i--){
            //可以作为前面一个结点
            if(arr[i]<arr[index]&&dp[i]==dp[index]-1){
                res[--len]=arr[i];
                index=i;
            }
        }
        return res;
    }
    public static int[]getDp(int[]arr){
        int[]dp=new int[arr.length];
        for (int i=0;i<arr.length;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        int[]arr={2,1,5,3,6,4,8,9,7};
        int[]res=generate(arr);
        Arrays.stream(res).forEach(System.out::println);
    }
}
