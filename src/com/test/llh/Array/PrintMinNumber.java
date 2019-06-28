package com.test.llh.Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 把数组排成最小的数
 */
public class PrintMinNumber {

    public static String printMinNumber(int [] numbers) {
        if(numbers==null||numbers.length==0){
            return "";
        }
        ArrayList<Integer>list=new ArrayList<>();
        String s="";
        for(int num:numbers){
            list.add(num);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String s1=o1+""+o2;
                String s2=o2+""+o1;
                return s1.compareTo(s2);
            }
        });
        for(int num:list){
            s+=num;
        }
        return s;
    }

    public static void main(String[] args) {
        int[]arr={3,32,321};
        String str=printMinNumber(arr);
        System.out.println(str);
    }
}
