package com.test.llh.Link;

public class DeletNodes {
    public static ListNode deleteNode(ListNode node){
        if (node==null){
            return node;
        }
        ListNode cur=node;
        ListNode pre=null;
        ListNode next=null;
        while (cur!=null){
            pre=cur;
            next=cur.next;
            while (next!=null){
                if(cur.val==next.val){
                    pre.next=next.next;
                }else {
                    pre=next;
                }
                next=next.next;
            }
            cur=cur.next;
        }
        return node;
    }
    public static ListNode delete(ListNode node){
        if (node==null){
            return node;
        }
        ListNode pre=null;
        ListNode cur=node;
        while (cur!=null){
            if (cur.next!=null&&cur.next.val==cur.val){
                int val=cur.val;
                while (cur.next!=null&&cur.next.val==val){
                    cur=cur.next;
                }
                if (pre==null){
                    node=cur.next;
                }else {
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
        node.next=new ListNode(1);
        node.next.next=new ListNode(2);
        node.next.next.next=new ListNode(3);
        ListNode res=delete(node);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
