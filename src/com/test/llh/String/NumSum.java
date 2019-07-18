package com.test.llh.String;

/**
 * 字符串中数子子串求和AB-12CD12D10:-12+12+10=10
 */
public class NumSum {
    public int getNumSum(String str){
        if (str==null){
            return 0;
        }
        char[]arr=str.toCharArray();
        int res=0;//累加和
        int cur=0;//当前字符的值
        int num=0;//数子累加
        boolean pos=true;
        for (int i=0;i<arr.length;i++){
            cur=arr[i]-'0';
            //当不是数子时进行累加
            if (cur<0||cur>9){
               res+=num;
               num=0;
               if (arr[i]=='-'){
                   if (i-1>-1&&arr[i-1]=='-'){
                       pos=!pos;
                   }else{
                       pos=false;
                   }
               }else{
                   pos=true;
               }
            }else{
                num=num*10+(pos?cur:-cur);
            }
        }
        //针对以数子结尾的情况
        res+=num;
        return res;
    }
}
