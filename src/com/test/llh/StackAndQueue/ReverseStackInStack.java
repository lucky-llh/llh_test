package com.test.llh.StackAndQueue;

import java.util.Stack;

/**
 * 仅用递归函数和栈操作逆序一个栈：
 * 1.设计两个递归函数：
 *  （1）设计一个取栈低并移除栈低元素的递归函数
 *  （2）逆序递归函数
 */
public class ReverseStackInStack {
    /**
     * 取栈低元素
     * @param stack
     * @return
     */
    public static int getAndRemoveLastElement(Stack<Integer>stack){
        int result=stack.pop();
        if(stack.isEmpty()){
            return result;
        }else {
            int last=getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    public static void reverse(Stack<Integer>stack){
        if (stack.isEmpty()){
            return;
        }
        int i=getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    public static void main(String[] args) {
        Stack<Integer>stack=new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        reverse(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
