package com.test.llh.Recur;

/**
 * 最长公共子序列问题：
 * 使用动态规划：dp[i][j]表示0..i,0..j上最长子序列的长度
 */
public class MaxConmLcs {
    public static int[][]getDp(char[]arr1,char[]arr2){
        int[][]dp=new int[arr1.length][arr2.length];
        dp[0][0]=arr1[0]==arr2[0]?1:0;
        for (int i=1;i<arr1.length;i++){
            dp[i][0]=Math.max(dp[i-1][0],arr1[i]==arr2[0]?1:0);
        }
        for (int j=1;j<arr2.length;j++){
            dp[0][j]=Math.max(dp[0][j-1],arr1[0]==arr2[j]?1:0);
        }
        for (int i=1;i<arr1.length;i++){
            for (int j=1;j<arr2.length;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                if (arr1[i]==arr2[j]){
                    dp[i][j]=Math.max(dp[i][j],dp[i-1][j-1]+1);
                }
            }
        }
        return dp;
    }

    /**
     * 根据dp逆推求出最长公共子序列
     * @param str1
     * @param str2
     * @return
     */
    public static String getLcs(String str1,String str2){
        if (str1==null||str2==null||str1.length()==0||str2.length()==0){
            return "";
        }
        char[]arr1=str1.toCharArray();
        char[]arr2=str2.toCharArray();
        int[][]dp=getDp(arr1,arr2);
        int m=str1.length()-1;
        int n=str2.length()-1;
        char[]res=new char[dp[m][n]];
        int index=res.length-1;
        while (index>=0){
            if(m>0&&dp[m][n]==dp[m-1][n]){
                m--;
            }else if (n>0&&dp[m][n]==dp[m][n-1]){
                n--;
            }else{
                res[index--]=arr1[m];
                m--;
                n--;
            }
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        String str1="1A2C3D4B56";
        String str2="B1D23CA45B6A";
        String res=getLcs(str1,str2);
        System.out.println(res);
    }
}

