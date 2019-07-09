package com.test.llh.Link;

import java.util.List;

/**
 * 删除链表中间节点：
 * 1->2,删除1
 * 1->2->3，删除2
 * 1->2->3->4,删除2
 * 1->2->3->4->5,删除5
 * 由上可知链表长度每增加2，删除的结点就右移一位
 *
 */
public class RemoveMidNode {
    /**
     * 如果链表为空或者长度为1，直接返回
     * @param node
     * @return
     */
    public ListNode removeMidNode(ListNode node){
        if (node==null||node.next==null){
            return node;
        }
        ListNode pre=node;//要删除结点的前一个节点
        ListNode cur=node.next.next;
        while (cur.next!=null&&cur.next.next!=null){
            pre=pre.next;
            cur=cur.next.next;
        }
        pre.next=pre.next.next;
        return node;
    }

    /**
     * 删除a/b处的结点,
     * 要根据链表的长度计算出要删除的结点，找到要删除结点的前一个节点
     * 1->2->3->4->5，假设a/b的值为r
     * 如果r==0,不删除任何结点
     * r在（0,1/5]上，删除结点1
     * r在(1/5,2/5]上，删除结点2
     * ...
     * @param node
     * @return
     */
    public static ListNode removeabNode(ListNode node,int a,int b){
        if (a<1||a>b){
            return node;
        }
        int n=0;
        ListNode cur=node;
        while(cur!=null){
            n++;
            cur=cur.next;
        }
        n=(int)Math.ceil(((double)(a*n))/(double)b);
        if(n==1){
            node=node.next;
        }
        if(n>1){
            cur=node;
            while (--n!=1){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        int a=4,b=5;
        ListNode cur=removeabNode(node,a,b);
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
