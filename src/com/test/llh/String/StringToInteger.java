package com.test.llh.String;

/**
 * 将整数字符串转换成整数值：
 * 思路：
 * 1.首先判断字符串是否合法：
 *    1.以- 开头但长度为1或者长度大于1后面跟着是0，不合法
 *    2.不以- 开头也不以数子开头不合法
 *    3.以0开头长度大于1不合法
 * 2.按照负数形式转换，最后根据符号位返回结果，因为最小值的绝对值大于最大值的绝对值
 */
public class StringToInteger {
    public boolean isValid(char[]arr){
        if (arr[0]=='-'&&(arr.length==1||arr[1]=='0')){
            return false;
        }
        if (arr[0]!='-'&&(arr[0]<'0'||arr[0]>'9')){
            return false;
        }
        if (arr[0]=='0'&&arr.length>1){
            return false;
        }
        for (int i=1;i<arr.length;i++){
            if (arr[i]<'0'||arr[i]>'9'){
                return false;
            }
        }
        return true;
    }
    public Integer stringToInteger(String str){
        if (str==null||str.length()==0){
            return 0;
        }
        char[]arr=str.toCharArray();
        if (!isValid(arr)){
            return 0;
        }
        int minq=Integer.MIN_VALUE/10;
        int minr=Integer.MIN_VALUE%10;
        int res=0;
        boolean pos=arr[0]=='-'?false:true;
        int cur=0;
        for (int i=pos?0:1;i<arr.length;i++){
            cur='0'-arr[i];
            if (res<minq||(res==minq&&cur<minr)){
                return 0;//会溢出
            }
            res=res*10+cur;
        }
        //正数不合法
        if (pos&&res==Integer.MIN_VALUE){
            return 0;
        }
        return pos?-res:res;


    }
}
