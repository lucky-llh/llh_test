package com.test.llh.StackAndQueue;

import java.util.Stack;

/**
 * 设计一个有getMin功能的栈
 * 思路：定义两个栈stackData和stackMin，stackData中存放正常数据，stackMin中存放最小值数据
 * 压入规则：
 * newNum压入stackData中，然后判断stackMin是否为空，若为空，将newNum入栈，
 * 若不为空，判断newNum与stackMin的栈顶元素谁小，谁小就将谁入stackMin中
 * 最后弹出元素时，将stackData以及stackmin中各弹出一个，
 * stackMin栈顶元素就为最小值
 */
public class MyStack {
    private Stack<Integer>stackData;
    private Stack<Integer>stackMin;
    public MyStack(){
        this.stackData=new Stack<>();
        this.stackMin=new Stack<>();
    }
    public void push(int num){
        if (stackMin.isEmpty()){
            stackMin.push(num);
        }else if(num<=stackMin.peek()){
            stackMin.push(num);
        }else{
            stackMin.push(stackMin.peek());
        }
        stackData.push(num);
    }
    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        stackMin.pop();
        return stackData.pop();
    }
    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return stackMin.peek();
    }


}
