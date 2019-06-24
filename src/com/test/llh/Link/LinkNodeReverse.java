package com.test.llh.Link;

import java.util.ArrayList;

public class LinkNodeReverse {
    public ArrayList<Integer>printNode(ListNode node){
        ArrayList list=new ArrayList();
        ListNode pre=null;
        ListNode next=null;
        ListNode head=node;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        while (pre!=null){
            list.add(pre.val);
            pre=pre.next;
        }
        return list;
    }
}
