package com.test.llh.Link;

import java.util.List;
import java.util.Stack;
/**
 * 将单链表的每k个结点进行逆序，不足k个结点的不进行逆序
 * 方法1：利用栈实现，当栈中元素个数到达k个时，就弹栈链接，每次记录反转后最后一个节点，和下此反转时的头结点进行拼接
 * 方法2：使用变量记录每组反转后的最后一个节点，上一次反转的最后一个节点
 */
public class ReverseKNode {
    public static ListNode reverseKNodeByStack(ListNode node,int k){
        if (k<2){
            return node;
        }
        Stack<ListNode>stack=new Stack<>();
        ListNode cur=node;
        ListNode pre=null;
        ListNode next=null;
        ListNode head=node;
        while (cur!=null){
            next=cur.next;
            stack.push(cur);
            if (stack.size()==k){
                head=head==node?cur:head;//纪录新的头结点，最后返回
                //pre是此次反转的最后一个节点，也是下此要与下组链表进行拼接的左边的结点
                pre=resign(stack,pre,next);
            }
            cur=next;
        }
        return head;
    }
    public static ListNode resign(Stack<ListNode>stack,ListNode left,ListNode right){
        ListNode node=stack.pop();
        if (left!=null){
            left.next=node;
        }
        ListNode next=null;
        while (!stack.isEmpty()){
            next=stack.pop();
            node.next=next;
            node=next;
        }
        //与剩下的链表进行拼接
        node.next=right;
        //反转后的最后一个节点
        return node;
    }
    public static ListNode reverseKNode(ListNode node,int k){
        if (k<2){
            return node;
        }
        ListNode cur=node;
        ListNode pre=null;
        ListNode next=null;
        ListNode start=node;
        int count=1;
        while (cur!=null){
            next=cur.next;
            //当元素个数到达k个时
            if (count==k){
                //链表的开始部分
                start=pre==null?node:pre.next;
                node=pre==null?cur:node;
                resign2(pre,start,cur,next);
                pre=start;
                //反转后将count置为0
                count=0;
            }
            cur=next;
            count++;
        }
        return node;
    }
    public static void resign2(ListNode left,ListNode start,ListNode end,ListNode right){
        ListNode pre=start;
        ListNode cur=start.next;
        ListNode next=null;
        while (cur!=right){
            next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        if (left!=null){
            left.next=end;//end为反转后的头结点
        }
        //与剩余链表进行拼接
        start.next=right;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        node.next.next.next.next.next=new ListNode(6);
        node.next.next.next.next.next.next=new ListNode(7);
        node.next.next.next.next.next.next.next=new ListNode(8);
        int k=3;
        ListNode res=reverseKNodeByStack(node,k);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
