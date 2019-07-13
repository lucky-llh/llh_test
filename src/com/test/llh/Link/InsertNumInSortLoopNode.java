package com.test.llh.Link;

/**
 * 向有序的环形单链表中插入新结点
 */
public class InsertNumInSortLoopNode {
    /**
     * 1.如果原始链表为null，就将该元素生成node结点自己组成环返回
     * 2.否则，遍历链表，如果num生成的结点值在两个结点之间，就插入，返回原始头结点
     *   若遍历完毕都没发现这样的位置，说明该值要么比当前链表结点值都大或都小，插入表头，若是都大的情况，返回原始头结点即可，否则，返回node生成的头结点
     * @param head
     * @param num
     * @return
     */
    public static ListNode insertNode(ListNode head,int num){
        ListNode node=new ListNode(num);
        if (head==null){
            node.next=node;
            return node;
        }
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=head){
            if (num>=pre.val&&num<=cur.val){
                break;
            }
            pre=cur;
            cur=cur.next;
        }
        pre.next=node;
        node.next=cur;
        return head.val<num?head:node;
    }

}
