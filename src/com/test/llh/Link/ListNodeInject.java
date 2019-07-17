package com.test.llh.Link;

import java.util.List;

/**
 * 两个链表相交的问题：给定链表的头结点
 * 1.首先判断链表是否有环，若有环返回入环结点
 * 2.若无环就转换成单链表相交问题
 * 3.若有环就转换成有环链表相交问题
 */
public class ListNodeInject {
    /**
     * 判断链表是否有环，返回入环结点
     * 定义快慢指针，若快指针先遇到null,说明无环
     * 否则，当快慢指针第一次相遇时，让快指针从头开始，此时快慢指针都一次走一步，再次相遇的结点就是入环结点
     * @param node
     * @return
     */
    public static ListNode getLoopNode(ListNode node){
        if (node==null) {
            return node;
        }
        ListNode slow=node.next;
        ListNode fast=node.next.next;
        while (slow!=fast){
            if (fast.next==null||fast.next.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=node;
        while (fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }

    /**
     * 单链表相交问题
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode singleNode(ListNode node1,ListNode node2){
        if (node1==null||node2==null){
            return null;
        }
        ListNode cur1=node1;
        ListNode cur2=node2;
        int n=0;
        while (cur1!=null){
            n++;
            cur1=cur1.next;
        }
        while (cur2!=null){
            n--;
            cur2=cur2.next;
        }
        //最后一个节点不相同
//        if (cur1.val!=cur2.val){
//            return null;
//        }
        cur1=n>0?node1:node2;
        cur2=cur1==node1?node2:node1;
        n=Math.abs(n);
        while (n!=0){
            n--;
            cur1=cur1.next;
        }
        while (cur1.val!=cur2.val){
            cur1=cur1.next;
            cur2=cur2.next;
        }
        return cur1;
    }

    /**
     * 环形链表相交问题
     * @param node1
     * @param loop1
     * @param node2
     * @param loop2
     * @return
     */
    public static ListNode loopNode(ListNode node1,ListNode loop1,ListNode node2,ListNode loop2){
        //转换成单链表相交问题
        if (loop1==loop2){
            ListNode cur1=node1;
            ListNode cur2=node2;
            int n=0;
            while (cur1!=null){
                n++;
                cur1=cur1.next;
            }
            while (cur2!=null){
                n--;
                cur2=cur2.next;
            }
            cur1=n>0?node1:node2;
            cur2=cur1==node1?node2:node1;
            n=Math.abs(n);
            while (n!=0){
                n--;
                cur1=cur1.next;
            }
            while (cur1!=cur2){
                cur1=cur1.next;
                cur2=cur2.next;
            }
            return cur1;
        }else{
            ListNode cur=loop1.next;
            while (cur!=loop1){
                //在遍历过程中遇到了loop2结点
                if (cur.val==loop2.val){
                    return loop1;
                }
                cur=cur.next;
            }
            return null;
        }
    }
    public static ListNode injectNode(ListNode node1,ListNode node2){
        if (node1==null||node2==null){
            return null;
        }
        ListNode loop1=getLoopNode(node1);
        ListNode loop2=getLoopNode(node2);
        if (loop1==null&&loop2==null){
            return singleNode(node1,node2);
        }
        if (loop1!=null&&loop2!=null) {
            return loopNode(node1, loop1, node2, loop2);
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        node1.next=new ListNode(2);
        node1.next.next=new ListNode(3);
        node1.next.next.next=new ListNode(4);
        node1.next.next.next.next=new ListNode(5);
        ListNode node2=new ListNode(3);
        node2.next=new ListNode(4);
        node2.next.next=new ListNode(5);
        System.out.println(injectNode(node1,node2).val);
    }
}
