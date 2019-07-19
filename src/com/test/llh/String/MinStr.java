package com.test.llh.String;

/**
 * 最小包含子串的长度
 */
public class MinStr {
    public int getMinLen(String str1,String str2 ){
        if (str1==null||str2==null||str1.length()<str2.length()){
            return 0;
        }
        char[]arr1=str1.toCharArray();
        char[]arr2=str2.toCharArray();
        int match=arr2.length;
        int min=Integer.MAX_VALUE;
        int[]map=new int[256];
        for (int i=0;i< arr2.length;i++){
            map[arr2[i]]++;
        }
        int left=0;
        int right=0;
        while (right!=str1.length()){
            map[arr1[right]]--;
            //<0表示多归还的，match不变
            if (map[arr1[right]]>=0){
                match--;
            }
            //当match==0时，left右移动，找到当前以right结尾的最短子串长度
            if (match==0){
                //说明拿走也不欠str2的
                while (map[arr1[left]]<0){
                    map[arr1[left++]]++;
                }
                min=Math.min(min,right-left+1);
                //
                match++;
                map[arr1[left++]]++;
            }
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}
