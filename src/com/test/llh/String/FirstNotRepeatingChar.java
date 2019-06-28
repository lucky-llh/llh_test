package com.test.llh.String;

/**
 * 第一个只出现一次的字符：
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstNotRepeatingChar {
    /**
     * 可以用map记录每一个字符出现的次数，最后返回num=1的字符
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar(String str) {
        if(str==""||str.length()==0){
            return -1;
        }
        int[]map=new int[256];
        for(int i=0;i<str.length();i++){
            map[str.charAt(i)]++;
        }
        for(int i=0;i<str.length();i++){
            if(map[str.charAt(i)]==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str="abcddssb";
        System.out.println(FirstNotRepeatingChar(str));
    }
}
