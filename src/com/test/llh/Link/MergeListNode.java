package com.test.llh.Link;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeListNode {
    public static ListNode merge(ListNode list1,ListNode list2){
        if(list1==null||list2==null){
            return list1==null?list2:list1;
        }
        ListNode node=list1.val<list2.val?list1:list2;
        ListNode cur1=node==list1?list1:list2;
        ListNode cur2=cur1==list1?list2:list1;
        ListNode pre=null;
        ListNode next=null;
        while (cur1!=null&&cur2!=null){
            if(cur1.val<=cur2.val){
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
        return node;
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
        ListNode node=merge(node1,node2);
        while (node!=null){
            System.out.print(node.val+" ");
            node=node.next;
        }
    }
}
