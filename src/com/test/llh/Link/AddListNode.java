package com.test.llh.Link;

import javax.swing.*;
import java.util.List;
import java.util.Stack;

/**
 * 两个单链表相加：每个节点值都是0-9之间的数
 */
public class AddListNode {
    /**
     * 方法1：借助栈实现（先进后出）相当于从低位到高位依次累加，记录进位值
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode addListNodeByStack(ListNode head1,ListNode head2){
        Stack<Integer>stack1=new Stack<>();
        Stack<Integer>stack2=new Stack<>();
        ListNode cur1=head1;
        ListNode cur2=head2;
        while (cur1!=null){
            stack1.push(cur1.val);
            cur1=cur1.next;
        }
        while (cur2!=null){
            stack2.push(cur2.val);
            cur2=cur2.next;
        }
        //记录进位
        int ca=0;
        //记录两个数的累加和
        int n=0;
        //记录stack1弹出的元素
        int n1=0;
        //记录stack2弹出的元素
        int n2=0;
        ListNode pre=null;
        ListNode node=null;
        while (!stack1.isEmpty()||!stack2.isEmpty()){
            n1=stack1.isEmpty()?0:stack1.pop();
            n2=stack2.isEmpty()?0:stack2.pop();
            n=n1+n2+ca;
            pre=node;
            node=new ListNode(n%10);
            //头插
            node.next=pre;
            ca=n/10;//进位值
        }
        //查看进位情况
        if (ca==1){
            pre=node;
            node=new ListNode(1);
            node.next=pre;
        }
        return node;
    }

    /**
     * 先将链表反转，然后从头遍历连边进行累加，最后返回前将链表反转
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode addListNode(ListNode node1,ListNode node2){
        node1=reverseNode(node1);
        node2=reverseNode(node2);
        ListNode cur1=node1;
        ListNode cur2=node2;
        int n=0;
        int ca=0;
        int n1=0;
        int n2=0;
        ListNode pre=null;
        ListNode node=null;
        while (cur1!=null||cur2!=null){
            n1=cur1==null?0:cur1.val;
            n2=cur2==null?0:cur2.val;
            n=n1+n2+ca;
            pre=node;
            node=new ListNode(n%10);
            node.next=pre;
            ca=n/10;
            cur1=cur1!=null?cur1.next:null;
            cur2=cur2!=null?cur2.next:null;
        }
        if (ca==1){
            pre=node;
            node=new ListNode(1);
            node.next=pre;
        }
        reverseNode(node1);
        reverseNode(node2);
        return node;
    }
    public static ListNode reverseNode(ListNode node){
        ListNode pre=null;
        ListNode next=null;
        while (node!=null){
            next=node.next;
            node.next=pre;
            pre=node;
            node=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(9);
        node1.next=new ListNode(3);
        node1.next.next=new ListNode(7);
        ListNode node2=new ListNode(6);
        node2.next=new ListNode(3);
        ListNode res=addListNodeByStack(node1,node2);
        while (res!=null){
            System.out.print(res.val+" ");
            res=res.next;
        }
    }
}
