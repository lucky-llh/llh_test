package com.test.llh.Link;

import java.util.List;
import java.util.Timer;

/**
 * 反转部分单向链表
 */
public class ReversePartNode {
    /**
     * 把from-to这部分的链表进行反转
     * 思路：首先找到from前面的结点和to后面的结点，将from-to部分的链表反转，然后进行拼接
     * @param node
     * @param from
     * @param to
     * @return
     */
    public static ListNode reversePart(ListNode node,int from,int to){
        int len=0;
        ListNode node1=node;
        ListNode fPre=null;
        ListNode tPost=null;
        while (node1!=null){
            len++;
            fPre=len==from-1?node1:fPre;
            tPost=len==to+1?node1:tPost;
            node1=node1.next;
        }
        if (from> to||from<1||to>len){
            return node;
        }
        //反转部分头结点
        node1=fPre==null?node:fPre.next;
        ListNode node2=node1.next;
        node1.next=tPost;
        ListNode next=null;
        while (node2!=tPost){
            next=node2.next;
            node2.next=node1;
            node1=node2;
            node2=next;
        }
        if (fPre!=null){
            fPre.next=node1;
            return node;
        }
        return node1;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        int from=2;
        int to=4;
        ListNode reverseNode=reversePart(node,from,to);
        while (reverseNode!=null){
            System.out.println(reverseNode.val);
            reverseNode=reverseNode.next;
        }
    }
}
