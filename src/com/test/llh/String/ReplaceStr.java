package com.test.llh.String;

/**
 * 替换字符串中连续出现的字符串：
 * str,from,to将str中from替换成to:
 * 定义一个变量match,表示目前匹配到from的什么位置，
 * 从左到右遍历str
 * 如果str[i]=from[match],并且match到达from的最后一个位置，从i位置开始往左遍历from长度清0，若未到达from最后一个位置，继续遍历.
 * 如果str[i]!=from[match],说明match匹配失败，让match=0,如果此时str[i]和match=0匹配，就从当前位置开始，否则从str下一个位置 开始
 * 最后将字符串中的o替换为to
 */
public class ReplaceStr {
    public String replaceStr(String str,String from,String to){
        if (str==null||from==null||str.equals("")||from.equals("")){
            return str;
        }
        char[]sarr=str.toCharArray();
        char[]farr=from.toCharArray();
        int match=0;
        for (int i=0;i<sarr.length;i++){
            if (sarr[i]==farr[match++]){
                if (match==farr.length){
                    clear(sarr,i, farr.length);
                    match=0;
                }
            }else{
                if (sarr[i]==farr[0]){
                    i--;
                }
                match=0;
            }
        }
        String res="";
        String cur="";
        for(int i=0;i<sarr.length;i++){
            if (sarr[i]!=0){
                cur=cur+String.valueOf(sarr[i]);
            }
            //0字符的开头
            if (sarr[i]==0&&(i==0||sarr[i-1]!=0)){
                res=res+cur+to;
                cur="";
            }
        }
        if (!cur.equals("")){
            res=res+cur;
        }
        return res;
    }
    public void clear(char[]arr,int end,int len){
        while (len--!=0){
            arr[end--]=0;
        }
    }
}
