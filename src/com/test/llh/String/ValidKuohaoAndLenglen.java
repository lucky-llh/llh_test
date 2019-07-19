package com.test.llh.String;

/**
 * 判断括号字符串的有效性以及最长有效括号的长度
 */
public class ValidKuohaoAndLenglen {
    public boolean isValid(String str){
        if (str==null||str.equals("")){
            return false;
        }
        char[]arr=str.toCharArray();
        int num=0;//左括号出现时加加，右括号出现时减减，当小于0说明不是有效的
        for(int i=0;i< arr.length;i++){
            if (arr[i]!='('&&arr[i]!=')'){
                return false;
            }else if (arr[i]==')'&&--num<0){
                return false;
            }else if (arr[i]=='('){
                num++;
            }
        }
        return true;
    }

    /**
     * 有效括号的最大长度：动态规划：
     * dp[i]表示必须以i结尾的有效括号的最长长度
     * dp[0]=0;
     * str[i]='(',dp[i]=0;
     * str[i]=')',有可能有有效括号str的i-dp[i-1]-1是不是（，如果是dp[i]至少为dp[i-1]+2;还要继续判定i-dp[i-1]-2上的有效长度
     * @param str
     * @return
     */
    public int maxLength(String str){
        if (str==null||str.equals("")){
            return 0;
        }
        char[]arr=str.toCharArray();
        int[]dp=new int[arr.length];
        int pre=0;
        int res=0;
        for (int i=1;i<arr.length;i++){
            if (arr[i]==')'){
                pre=i-dp[i-1]-1;
                if (pre>=0&&arr[pre]=='('){
                    dp[i]=dp[i-1]+2+(pre>0?dp[pre-1]:0);
                }
            }
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}
