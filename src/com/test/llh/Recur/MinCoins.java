package com.test.llh.Recur;

/**
 * 换钱的最小货币数
 */
public class MinCoins {
    /**
     * 数组中的元素代表面值为它的可以是任意张：
     * 动态规划dp[i][j]表示在使用0..i上的任意张货币组成j所需的最小货币数
     * @param arr
     * @param aim
     * @return
     */
    public int minCoins(int[]arr,int aim){
        if (arr==null||arr.length==0||aim<0){
            return -1;
        }
        int n=arr.length;
        int max=Integer.MAX_VALUE;
        int[][]dp=new int[n][aim+1];
        //第一列dp[i[[[0]都为0
        //第一行的值：aim是某以货币值的arr[0]正数倍时，该位置为1,
        for (int i=1;i<=aim;i++){
            dp[0][i]=max;
            if (i-arr[0]>0&&dp[0][i-arr[0]]!=max){
                dp[0][i-arr[0]]=1;
            }
        }
        //其余元素从左到右，从上到下以此计算
        int left=0;
        for (int i=1;i<n;i++){
            for (int j=1;j<=aim;j++){
                left=max;
                if(j-arr[i]>0&&dp[i][j-arr[i]]!=max){
                    left=dp[i][j-arr[i]]+1;
                }
                dp[i][j]=Math.min(left,dp[i-1][j]);
            }
        }
        return dp[n-1][aim]!=max?dp[n-1][aim]:-1;
    }

    /**
     * 数组中的值代表一种面值的货币只有一张：
     *动态规划：dp[i][j]代表0..i上的货币组成j最小张数
     * 第一列的值表示dp[i][0]组成aim=0的货币张数，全为0
     * 第一行的值表示dp[0][j]使用arr[0]代表的面值组成aim=j的情况，所以只有arr[0]=aim时的位置do值为1，其余为0
     * 其余行从左到右，从上到下以此计算：dp[i][j]的值取决于不使用arr[i】的情况：dp[i-1][j],使用arr[i],dp[i-1][j-arr[i]]+1;
     * @param arr
     * @param aim
     * @return
     */
    public int minCoins2(int[]arr,int aim){
        if (arr==null||arr.length==0||aim<0){
            return -1;
        }
        int n=arr.length;
        int max=Integer.MAX_VALUE;
        int[][]dp=new int[n][aim+1];
        dp[0][0]=0;
        for (int j=1;j<=aim;j++){
            dp[0][j]=max;
        }
        if (arr[0]<=aim){
            dp[0][arr[0]]=1;
        }
        int left=0;
        for (int i=1;i<n;i++){
            for (int j=1;j<=aim;j++){
                left=max;
                if (j-arr[i]>0&&dp[i-1][j-arr[i]]>0){
                    left=dp[i-1][j-arr[i]]+1;
                }
                dp[i][j]=Math.min(dp[i-1][j],left);
            }
        }
        return dp[n-1][aim]!=max?dp[n-1][aim]:-1;
    }
}
