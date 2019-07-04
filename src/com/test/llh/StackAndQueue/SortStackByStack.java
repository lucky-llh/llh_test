package com.test.llh.StackAndQueue;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序：从栈顶到栈低：从大到小（只可以申请一个辅助栈和变量）
 * 思路：申请一个辅助栈help,让help中的元素从栈顶到栈低：从小到大，最后再将help中的元素放入stack中
 * 压入help栈的规则：当stack中的元素比help栈顶元素小或者等于，就入help栈，否则将help栈中的元素取出放入stack中知道满足入栈要求
 *
 */
public class SortStackByStack {

    public static void sortStackByOtherStack(Stack<Integer>stack){
        Stack<Integer>help=new Stack<>();
        while (!stack.isEmpty()){
            int cur=stack.pop();
            while (!help.isEmpty()&&help.peek()<cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()){
            stack.push(help.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer>stack=new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);
        sortStackByOtherStack(stack);
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
}
