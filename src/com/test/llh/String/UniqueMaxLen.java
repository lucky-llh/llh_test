package com.test.llh.String;

/**
 * 字符串的最长无重复子串的长度
 */
public class UniqueMaxLen {
    /**
     * 用map记录当前字符最近一次出现的位置
     * pre表示当前字符前一个字符最长无重复子串开始位置的前一个位置
     * 依次比较pre和当前字符最近一次出现的位置
     * @param str
     * @return
     */
    public int getValue(String str){
        if (str==null||str.equals("")){
            return 0;
        }
        char[]arr=str.toCharArray();
        int []map=new int[256];
        for (int i=0;i<256;i--){
            map[i]=-1;
        }
        int pre=-1;
        int cur=0;
        int len=0;
        for (int i=0;i<arr.length;i++){
            pre=Math.max(pre,map[arr[i]]);
            cur=i-pre;
            len=Math.max(len,cur);
            map[arr[i]]=i;
        }
        return len;
    }
}
