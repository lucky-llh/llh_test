package com.test.llh.String;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 *
 * 字符串的全排列：回溯法
 */
public class StringPermutation {

    public static ArrayList<String> permutation(String str) {
        ArrayList<String>list=new ArrayList<>();
        if(str==""||str.length()==0){
            return list;
        }
        process(str.toCharArray(),list,0);
        Collections.sort(list);
        return list;
    }
    public static void process(char[]arr,ArrayList<String>list,int begin){
        //一次排序终止的条件
        if(begin==arr.length-1){
            String string=new String(arr);
            //防止重复，直接申请个set对象也可以
            if(!list.contains(string)){
                list.add(string);
            }
        }else {
            for(int j=begin;j<arr.length;j++){
                swap(arr,begin,j);//固定第一位
                process(arr,list,begin+1);//对剩下的几位记性全排
                swap(arr,begin,j);
            }
        }
    }
    public static void swap(char[]arr,int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        String str="abc";
       ArrayList<String>list= permutation(str);
       list.stream().forEach(System.out::println);
    }
}
