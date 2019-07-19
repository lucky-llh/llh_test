package com.test.llh.String;

/**
 * 回文最少分割数：
 * 给定一个字符串，最少切割多少次能使子串成为回文串：动态规划：
 * dp[i]表示在i..len-1上的最少分割数，所以最后的dp[0]就是结果
 * dp[i]的值计算：
 * 假设在i..len-1上有位置j使得i..j上是回文串，那么dp[i]的值就可能等于dp[j+1]+1;可以在i..j上切分一次，然后在j+1..len上在进行相应的最小切割
 * 所以应该找到j位置：
 * 从i往右遍历：
 * 满足回文的情况：
 * 1.只有一个字符船组成
 * 2.有两个字符组成且相等
 * 3.str[i]==str[j]并且i+1..j-1是回文串
 * 因为dp的值是从右往左一次求的，判断是否回文是从i位置往右，则i+1..j-1上是否是回文串肯定遭遇i..j上的判断
 */
public class MinCutInStr {
    public int mincut(String str){
        if (str==null||str.equals("")){
            return 0;
        }
        char[]arr=str.toCharArray();
        int[]dp=new int[arr.length];
        dp[arr.length]=-1;
        boolean[][]p=new boolean[arr.length][arr.length];
        int len=arr.length;
        for (int i=len-1;i>=0;i--){
            dp[i]=Integer.MAX_VALUE;
            for(int j=i;j<len;j++){
                if (arr[i]==arr[j]&&(j-i<2||p[i+1][j-1])){
                    p[i][j]=true;
                    dp[i]=Math.min(dp[i],dp[j+1]+1);
                }
            }
        }
        return dp[0];
    }
}
