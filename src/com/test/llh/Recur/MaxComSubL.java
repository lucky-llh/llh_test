package com.test.llh.Recur;

/**
 * 最长公共子串问题;dp[i][j]表示必须以i,j结尾的情况下，最长公共子串的长度
 */
public class MaxComSubL {
    public static int[][]getdp(char[]arr1,char[]arr2){
        int[][]dp=new int[arr1.length][arr2.length];
        for (int i=0;i<arr1.length;i++){
//            dp[i][0]=arr1[i]==arr2[0]?1:0;
            if(arr1[i]==arr2[0]){
                dp[i][0]=1;
            }
        }
        for (int j=1;j< arr2.length;j++){
//            dp[0][j]=arr1[0]==arr2[j]?1:0;
            if(arr1[0]==arr2[j]){
                dp[0][j]=1;
            }
        }
        for (int i=1;i<arr1.length;i++){
            for (int j=1;j<arr2.length;j++){
                if(arr1[i]==arr2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
            }
        }
        return dp;
    }
    public static String getSubString(String str1,String str2){
        if(str1==null||str2==null||str1.length()==0||str2.length()==0){
            return "";
        }
        char[]arr1=str1.toCharArray();
        char[]arr2=str2.toCharArray();
        int[][]dp=getdp(arr1,arr2);
        int max=0;
        int index=0;
        for (int i=0;i<arr1.length;i++){
            for (int j=0;j<arr2.length;j++){
                if(dp[i][j]>max){
                    max=dp[i][j];
                    index=i;
                }
            }
        }
        return str1.substring(index-max-1,index+1);
    }

    public static void main(String[] args) {
        String str1="1AB2345CD";
        String str2="12345EF";
        System.out.println(getSubString(str1,str2));
    }
}
