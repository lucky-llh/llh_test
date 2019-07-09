package com.test.llh.Link;

import java.util.List;

/**
 * 在单链表和双链表中删除倒数第k个节点:
 * 一种方法：单双链表的区别再去双链表要考虑前驱指针的问题
 * 1.首先判断链表是否为空以及k的值
 * 2.遍历链表让k--,最后根据k的值进行处理
 *   k>0说明不存在倒数第k个节点
 *   k==0说明倒数第k个节点就是头结点
 *   k<0,从头开始遍历，k++操作，当k==0时，说明找到倒数第k个节点的前一个节点，做删除操作
 *       因为第一次遍历k的值变为了k-n(链表长度)的值,倒数第k个节点的前一个节点就是第n-k个节点，所以让k-n一直做加加操作，知道为0时就找到了倒数第k节点的前驱节点
 *
 */
public class RemoveLastKthNode {
    /**
     * 删除单链表中倒数第k个节点
     * @param node
     * @return
     */
    public static ListNode removeLastKthNode(ListNode node,int k){
        if (node==null||k<1){
            return node;
        }
        ListNode cur=node;
        while (cur!=null){
            k--;
            cur=cur.next;
        }
        if (k==0){
            node=node.next;
        }
        if(k<0){
            cur=node;
            while (++k!=0){
                cur=cur.next;
            }
            cur.next=cur.next.next;
        }
        return node;
    }

    /**
     * 删除双链表中倒数第k个节点
     * @param node
     * @param k
     * @return
     */
    public static DoubleNode removeLastKthNode(DoubleNode node,int k){
        if (node==null||k<1){
            return node;
        }
        DoubleNode cur=node;
        while (cur!=null){
            k--;
            cur=cur.next;
        }
        if (k==0){
            node=node.next;
            node.last=null;
        }
        if(k<0){
            cur=node;
            while (++k!=0){
                cur=cur.next;
            }
            DoubleNode newNode=cur.next.next;
            cur.next=newNode;
            if (newNode!=null){
                newNode.last=cur;
            }
        }
        return node;
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
        int k=2;
        ListNode cur=removeLastKthNode(node,k);
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
        System.out.println("remove doubleNode");
        DoubleNode doubleNode1=removeLastKthNode(doubleNode,k);
        while (doubleNode1!=null){
            System.out.println(doubleNode1.val);
            doubleNode1=doubleNode1.next;
        }
    }
}
