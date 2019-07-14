package com.test.llh.Link;

/**
 * 按照左右分区的方式重新组合单链表：
 * 1-》1
 * 1-2:1-2
 * 1-2-3:1-2-3
 * 1-2-3-4:1-3-2-4
 * 1-2-3-4-5：1-3-2-4-5
 */
public class RelocateNode {
    public static void relocate(ListNode head){
        if (head==null){
            return;
        }
        ListNode mid=head;
        ListNode right=head.next;
        while (right.next!=null&&right.next.next!=null){
            right=right.next.next;
            mid=mid.next;
        }
        right=mid.next;
        mid.next=null;
        mergeNode(head,right);
    }
    public static void mergeNode(ListNode left,ListNode right){
        ListNode next=null;
        while (left.next!=null){
            next=right.next;
            right.next=left.next;
            left.next=right;
            left=right.next;
            right=next;
        }
        left.next=right;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next=new ListNode(4);
        relocate(node);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }
}
