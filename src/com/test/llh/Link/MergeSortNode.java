package com.test.llh.Link;

public class MergeSortNode {
    public static ListNode mergeSort(ListNode head1,ListNode head2){
        if (head1==null||head2==null){
            return head1==null?head2:head1;
        }
        ListNode head=head1.val<head2.val?head1:head2;
        ListNode cur1=head==head1?head1:head2;
        ListNode cur2=cur1==head1?head2:head1;
        //pre记录最小节点的前一个结点
        ListNode pre=null;
        ListNode next=null;
        while (cur1!=null&&cur2!=null){
            if (cur1.val<cur2.val){
                pre=cur1;
                cur1= cur1.next;
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

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        node1.next=new ListNode(2);
        node1.next.next=new ListNode(3);
        node1.next.next.next=new ListNode(4);

        ListNode node2=new ListNode(2);
        node2.next=new ListNode(3);
        node2.next.next=new ListNode(4);
        node2.next.next.next=new ListNode(5);
        ListNode node=mergeSort(node1,node2);
        while (node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
    }
}
