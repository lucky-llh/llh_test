package com.test.llh.StackAndQueue;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 栈特性：先进后出
 * 队列：先进先出
 * 思路：用一个栈存储元素，在弹出元素时，将存放元素的栈全部放入另外一个栈中
 */
public class TwoStackImplQueue {
    public Stack<Integer>stack1=new Stack();
    public Stack<Integer>stack2=new Stack<>();
    public void push(int val){
        stack1.push(val);
    }
    public int pop(){
        while (!stack1.isEmpty()&&stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
