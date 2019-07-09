package com.test.llh.Link;

import java.util.List;

/**
 * 反转单向和双向链表
 */
public class ReverseNode {
    public static ListNode reverseNode(ListNode node){
        if (node==null||node.next==null){
            return node;
        }
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
    public static DoubleNode reverseNode(DoubleNode node){
        if (node==null||node.next==null){
            return node;
        }
        DoubleNode pre=null;
        DoubleNode next=null;
        while (node!=null){
            next=node.next;
            node.next=pre;
            node.last=next;
            pre=node;
            node=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);

        DoubleNode doubleNode=new DoubleNode(1);
        doubleNode.next=new DoubleNode(2);
        doubleNode.next.last=doubleNode;
        doubleNode.next.next=new DoubleNode(3);
        doubleNode.next.next.last=doubleNode.next;

        ListNode listNode=reverseNode(node);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
        System.out.println("print doubleNode");
        DoubleNode doubleNode1=reverseNode(doubleNode);
        while (doubleNode1!=null){
            System.out.println(doubleNode1.val);
            doubleNode1=doubleNode1.next;
        }
    }
}
