package com.test.llh.String;

/**
 * 字符串的调整与替换
 * 给定一个字符数组，右半区全是空字符，左半区不含有空字符，把左半区所有空格字符替换为%20
 */
public class ReplaceString {
    /**
     * 遍历字符数组，统计空格字符的个数，以及左半区的长度，然后到者遍历一次替换
     * @param arr
     */
    public void replace(char[]arr){
        if (arr==null||arr.length==0){
            return;
        }
        int len=0;
        int count=0;
        for (len=0;len<arr.length&&arr[len]!=0;len++){
            if (arr[len]==' '){
                count++;
            }
        }
        int j=len+2*count-1;//替换后字符数组的长度（最后位置的索引）
        for (int i=len-1;i!=-1;i--){
            if (arr[i]!=' '){
                arr[j--]=arr[i];
            }else{
                arr[j--]='0';
                arr[j--]='2';
                arr[j--]='%';
            }
        }
    }

    /**
     * 字符数组中只含有字符和*，将*移到前面，字符放在后面
     * @param arr
     */
    public void modify(char[]arr){
        if(arr==null||arr.length==0){
            return;
        }
        int count=0;
        int j=arr.length-1;
        for (int i=arr.length-1;i>-1;i--){
            if (arr[i]!='*'){
                arr[j--]=arr[i];
            }
        }
        while (j>-1){
            arr[j--]='*';
        }
    }
}
