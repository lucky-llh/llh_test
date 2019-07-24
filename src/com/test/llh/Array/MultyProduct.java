package com.test.llh.Array;

/**
 * 不包含本位置的累成数组：
 * 1.可以使用除法
 * 2.不可使用除法
 */
public class MultyProduct {
    /**
     * 统计数组中0的个数，计算出非0的累乘积
     * 如果有一个0，除了0位置等于累乘积，其余位置为0
     * 如果有多个0，所有位置都为0
     * @param arr
     * @return
     */
    public int[] mulity1(int[]arr){
        if(arr==null||arr.length==0){
            return null;
        }
        int count=0;
        int res[]=new int[arr.length];
        int all=1;
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=0){
                all*=arr[i];
            }else{
                count++;
            }
        }
        if (count==0){
            for (int i=0;i<arr.length;i++){
                res[i]=all/arr[i];
            }
        }
        if (count==1){
            for (int i=0;i<arr.length;i++){
                if (arr[i]==0){
                    res[i]=all;
                }
            }
        }
        return res;
    }

    /**
     * 不使用乘法，每个位置等于左边累成*右边累成
     * @param arr
     * @return
     */
    public int[]multiy(int[]arr){
        if (arr==null||arr.length==0){
            return null;
        }
        int[]res=new int[arr.length];
        res[0]=arr[0];
        for (int i=1;i<arr.length;i++){
            res[i]=res[i-1]*arr[i];
        }
        int temp=1;
        for (int i=arr.length-1;i>0;i--){
            res[i]=res[i-1]*temp;
            temp*=arr[i];
        }
        res[0]=temp;
        return res;
    }
}
