package com.test.llh.Link;

import java.util.Stack;

/**
 * 单链表中删除指定值的结点
 */
public class RemoveNodeEqualsValue {
    /**
     * 用栈实现：栈中保存所有值不等于num的元素，最后用头插法拼接，最后返回栈底元素
     * @param node
     * @param num
     * @return
     */
    public static ListNode removeNodeByStack(ListNode node,int num){
        if (node==null){
            return node;
        }
        Stack<ListNode>stack=new Stack<>();
        while (node!=null){
            if (node.val!=num){
                stack.push(node);
            }
            node=node.next;
        }
        while (!stack.isEmpty()){
            stack.peek().next=node;
            node=stack.pop();
        }
        return node;
    }

    /**
     * 用变量来实现：首先找到第一个不等于num的结点作为头结点保存
     * @param node
     * @param num
     * @return
     */
    public static ListNode removeNode(ListNode node,int num){
        if (node==null){
            return node;
        }
        while (node!=null){
            if (node.val!=num){
                break;
            }else {
                node=node.next;
            }
        }
        ListNode pre=node;
        ListNode cur=node;
        while (cur!=null){
            if (cur.val==num){
                pre.next=cur.next;
            }else {
                pre=cur;
            }
            cur=cur.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        int num=2;
        ListNode res=removeNodeByStack(node,num);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
