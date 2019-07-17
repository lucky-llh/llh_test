package com.test.llh.Link;

import java.util.List;

/**
 * 链表奇数位递增，偶数位递减，将链表进行排序
 * 分为三步：
 * 1.将链表按照奇数位和偶数位拆分
 * 2.将偶数位链表反转
 * 3.合并两个有序链表
 */
public class OddIncreaseEvenDecrease {
    /**
     * 1.将链表拆分
     * @param head
     * @return
     */
    public static ListNode[]getNodesList(ListNode head){
        if (head==null){
            return null;
        }
        ListNode head1=null;
        ListNode head2=null;
        ListNode cur1=null;
        ListNode cur2=null;
        int count=0;
        while (head!=null){
            if (count%2==1){
                if (cur1!=null){
                    cur1.next=head;
                    cur1=cur1.next;
                }else{
                    cur1=head;
                    head1=cur1;
                }
            }else {
                if (cur2!=null){
                    cur2.next=head;
                    cur2=cur2.next;
                }else {
                    cur2=head;
                    head2=cur2;
                }
            }
            head=head.next;
            count++;
        }
        //循环结束，让最后两个结点的末尾元素指向null
        cur1.next=null;
        cur2.next=null;
        ListNode nodes[]=new ListNode[]{head1,head2};
        return nodes;
    }

    /**
     * 2.反转链表
     * @param node
     * @return
     */
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

    /**
     * 3.合并两个有序链表
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode mergeSortNode(ListNode head1,ListNode head2){
        if (head1==null||head2==null){
            return head1==null?head2:head1;
        }
        ListNode head=head1.val<head2.val?head1:head2;
        ListNode cur1=head==head1?head1:head2;
        ListNode cur2=cur1==head1?head2:head1;
        ListNode pre=null;
        ListNode next=null;
        while (cur1!=null&&cur2!=null){
            if (cur1.val<=cur2.val){
                pre=cur1;
                cur1=cur1.next;
            }else{
                next=cur2.next;
                pre.next=cur2;
                cur2.next=cur1;
                pre=cur2;
                cur2=next;
            }
        }
        pre.next=cur1==null?cur2:cur1;
        return head;
    }
    public static ListNode init(){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        return node1;
    }
    public static void main(String[] args) {
        ListNode node=init();
        ListNode[]nodes=getNodesList(node);
        ListNode head1=nodes[0];
        ListNode head2=nodes[1];
        head2=reverseNode(head2);
       node= mergeSortNode(head1,head2);
       while (node!=null){
           System.out.print(node.val+" ");
           node=node.next;
       }
    }
}
