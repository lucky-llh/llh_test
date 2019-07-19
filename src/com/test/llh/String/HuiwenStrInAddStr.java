package com.test.llh.String;

/**
 * 添加最少字符串使整体都是回文字符串
 */
public class HuiwenStrInAddStr {
    /**
     * 使用动态规划：
     * 定义一个二维数组dp[i][j]表示i..j上最少添加字符串的个数：
     * 分为三种情况：
     * 1.i..j上只有一个字符dp=0;
     * 2.i..j上有两个字符都相等时dp=0,不等时dp=1;
     * 3.i..j上大于两个字符时：
     *    1.str[i]==str[j]时，dp[i][j]=dp[i+1][j-1]上
     *    2.不等时看dp[i][j-1]与dp[i+1][j]上谁最小
     * 然后根据生成的动态数组，去求解回文字符串
     * @param str
     * @return
     */
    public String getHuiwenStr(String str){
        if (str==null||str.length()<2){
            return str;
        }
        char[]arr=str.toCharArray();
        int[][]dp=getDp(arr);
        char[]res=new char[arr.length+dp[0][arr.length-1]];//加上回文后的长度
        int i=0;
        int j=arr.length-1;
        int resl=0;
        int resr=res.length-1;
        //利用dp和arr两边进行填充res数组
        while (i<=j){
            if (arr[i]==arr[j]){
                res[resl++]=arr[i++];
                res[resr--]=arr[j--];
            }else if (dp[i][j-1]<dp[i+1][j]){
                res[resl++]=arr[j];
                res[resr--]=arr[j--];
            }else{
                res[resl++]=arr[i];
                res[resr--]=arr[i++];
            }
        }
        return String.valueOf(res);
    }
    public int[][]getDp(char[]arr){
        int[][]dp=new int[arr.length][arr.length];
        for(int j=1;j<arr.length;j++){
            dp[j-1][j]=arr[j-1]==arr[j]?0:1;
            for(int i=j-2;i>-1;i--){
                if (arr[i]==arr[j]){
                    dp[i][j]=dp[i+1][j-1];
                }else{
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j-1]);
                }
            }
        }
        return dp;
    }

    /**
     * 给定字符串和他的最长回文子序列：求最少添加几个字符串使其整体成为回文
     * @param str
     * @param strlp
     * @return
     */
    public String getHuiWenString(String str,String strlp){
        if (str==null||str.length()==0){
            return str;
        }
        char[]chas=str.toCharArray();
        int chasl=0;
        int chasr=chas.length-1;
        char[]lps=strlp.toCharArray();
        int lpsl=0;
        int lpsr=lps.length-1;
        char[]res=new char[2*chas.length-lps.length];
        int resl=0;
        int resr=res.length-1;
        int templ=0;
        int tempr=0;
        while (lpsl<=lpsr){
            templ=chasl;
            tempr=chasr;
            while(chas[chasl]!=lps[lpsl]){
                chasl++;
            }
            while (chas[chasr]!=lps[lpsr]){
                chasr--;
            }
            set(res,resl,resr,chas,templ,chasl,chasr,tempr);
            resl+=chasl-templ+tempr-chasr;
            resr-=chasl-templ+tempr-chasr;
            res[resl++]=chas[chasl++];
            res[resr--]=chas[chasr--];
            lpsl++;
            lpsr--;

        }
        return String.valueOf(res);
    }
    public void set(char[]res,int resl,int resr,char[]arr,int ls,int le,int rs,int re){
        for (int i=ls;i<le;i++){
            res[resl++]=arr[i];
            res[resr--]=arr[i];
        }
        for (int i=re;i>rs;i--){
            res[resl++]=arr[i];
            res[resr--]=arr[i];
        }
    }
}
