package com.test.llh.Array;

/**
 * 子矩阵的累加和：可以转换成子数组的累加和求解
 */
public class MaxSumInSubRectangle {
    public int maxLength(int[][]arr){
        if (arr==null||arr[0]==null||arr.length==0||arr[0].length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;
        int[]s=null;
        int cur=0;
        for (int i=0;i<arr.length;i++){
            s=new int[arr[0].length];
            for (int j=i;j<arr.length;j++){
                cur=0;
                for (int k=0;k<s.length;k++){
                    s[k]+=arr[j][k];
                    cur+=s[k];
                    max=Math.max(max,cur);
                    cur=cur<0?0:cur;
                }
            }
        }
        return max;
    }
}
