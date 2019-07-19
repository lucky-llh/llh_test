package com.test.llh.String;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 公式字符串求值：
 * 字符串中含有运算符和括号：用一个递归过程实现
 * 当开始遍历及遇到左括号时就进入递归，遇到右括号就结束递归，递归返回两个值：这次递归的结果以及以及便利到的位置，
 * 剩下的就是求没有括号的运算
 */
public class GetValueInGongshi {
    public int getValue(String exp){
        return value(exp.toCharArray(),0)[0];
    }
    public int[]value(char[]arr,int index){
        Deque<String>deque=new LinkedList<>();
        int pre=0;
        int res[]=null;
        while (index<arr.length&&arr[index]!=')'){
            if (arr[index]>='0'&&arr[index]<=9){
                pre=pre*10+arr[index++]-'0';
            }else if (arr[index]!='('){
                addNum(deque,pre);
                //把当前运算符加队列
                deque.addLast(String.valueOf(arr[index++]));
                pre=0;
            }else{
                //遇到左括号开始调用下次递归
                res=value(arr,index+1);
                pre=res[0];//本次递归的结果
                index=res[1]+1;//下次开始的位置
            }
        }
        addNum(deque,pre);
        return new int[]{getNum(deque),index};
    }
    public void addNum(Deque<String> deque,int num){
        int cur=0;
        String top=deque.pollLast();
        if (top.equals("+")||top.equals("-")){
            deque.addLast(top);
        }else{
            //对于乘除需要计算结国在入队
            cur=Integer.valueOf(deque.pollLast());
            num=top.equals("*")?(cur*num):(cur/num);
        }
        deque.addLast(String.valueOf(num));
    }
    public int getNum(Deque<String>deque){
        boolean flag=true;
        int res=0;
        String cur=null;
        int num=0;
        while (!deque.isEmpty()){
            cur=deque.pollFirst();
            if (cur.equals("+")){
                flag=true;
            }else if (cur.equals("-")){
                flag=false;
            }else{
                num=Integer.valueOf(cur);
                res+=flag?num:(-num);
            }
        }
        return res;
    }
}
