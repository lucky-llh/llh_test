package com.test.llh.Link;

import java.util.List;

/**
 * 两个链表的第一个公共结点：链表可能有环也可能无环
 */
public class FindFirstCommonNode {

    /**
     * 1.总体分为两大类：有环和无环链表相交问题
     * 2.无环链表里面再细分为入环结点是否相同
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode findFirstCommonNode(ListNode node1,ListNode node2){
        if(node1==null||node2==null){
            return null;
        }
        ListNode loop1=getLoop(node1);
        ListNode loop2=getLoop(node2);
        if(loop1==null&&loop2==null){
            return singleNode(node1,node2);
        }else if (loop1!=null&&loop2!=null){
            return roundNode(node1,loop1,node2,loop2);
        }else{
            return null;
        }
    }

    /**
     * 获取链表的入环结点
     * @param node
     * @return
     */
    public static ListNode getLoop(ListNode node){
        if(node==null){
            return null;
        }
        ListNode cur=node;
        ListNode slow=cur.next;
        ListNode fast=cur.next.next;
        while (slow!=fast){
            //快指针提前遇到null,说明是单链表
            if(fast.next==null||fast.next.next==null){
                return null;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=node;
        while (slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }

    /**
     * 单链表相交问题：两个链表的第一个相交结点
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode singleNode(ListNode node1,ListNode node2){
        if(node1==null|| node2==null){
            return  null;
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
        if(cur1!=cur2){
            return null;
        }
        ListNode head1=n>0?node1:node2;
        ListNode head2=head1==node1?node2:node1;
        n=Math.abs(n);
        //长链表先走n步
        while (n!=0){
            n--;
            head1=head1.next;
        }
        //一起走
        while (head1!=head2){
            head1=head1.next;
            head2=head2.next;
        }
        return head1;
    }

    /**
     * 环形链表相交问题
     * @param node1
     * @param loop1
     * @param node2
     * @param loop2
     * @return
     */
    public static ListNode roundNode(ListNode node1,ListNode loop1,ListNode node2,ListNode loop2){
        if(loop1==loop2){
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
            ListNode head1=n>0?node1:node2;
            ListNode head2=head1==node1?node2:node1;
            while (n!=0){
                n--;
                head1=head1.next;
            }
            while (head1!=head2){
                head1=head1.next;
                head2=head2.next;
            }
            return head1;
        }else{
            ListNode cur=loop1;
            while (cur!=loop1){
                if(cur==loop2){
                    return loop1;
                }
                cur=cur.next;
            }
            return null;
        }
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
        System.out.println(findFirstCommonNode(node1,node2).val);
    }
}
