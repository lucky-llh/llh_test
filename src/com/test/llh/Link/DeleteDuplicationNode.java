package com.test.llh.Link;

/**
 * 删除链表中重复的结点：
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class DeleteDuplicationNode {
    public static ListNode deleteNode(ListNode node){
        if (node==null){
            return null;
        }
        ListNode cur=node;
        ListNode pre=null;
        while (cur!=null){
            if (cur.next!=null&&cur.next.val==cur.val){
                int val=cur.val;
                while (cur.next!=null&&cur.next.val==val){
                    cur=cur.next;
                }
                if (pre==null){
                    node=cur.next;
                }else{
                    pre.next=cur.next;
                }
            }else{
                pre=cur;
            }
            cur=cur.next;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(3);
        node.next.next.next.next=new ListNode(4);
        node.next.next.next.next.next=new ListNode(4);
        node.next.next.next.next.next.next=new ListNode(5);
        ListNode cur=deleteNode(node);
        while (cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
    }
}
