package com.test.llh.String;

public class Solution {
    public static String replaceSpace(StringBuffer str) {
        int spacenum=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                spacenum++;
            }
        }
        int oldIndex=str.length()-1;
        int newLength=str.length()+2*spacenum;
        int newIndex=newLength-1;
        str.setLength(newLength);
        for(;oldIndex>=0&&oldIndex<newLength;oldIndex--){
            if(str.charAt(oldIndex)==' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
            }else{
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            }
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer("we like you");
        String str=replaceSpace(stringBuffer);
        System.out.println(stringBuffer.toString()+"============"+str);
    }
}
