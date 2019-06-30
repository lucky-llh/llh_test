package com.test.llh.Link;

/**
 * 查找单链表相交的第一个结点
 */
public class FindFirstCommonNodeInSingleNode {
    /**
     * 1.首先统计链表长度，让长的链表先走几步，然后一起走，最后找到相同的结点就返回
     * 2.如果两个单链表相交，则他们最后一个结点肯定相等，若不相等，肯定不相交
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode findCommonNode(ListNode node1,ListNode node2){
        if(node1==null||node2==null){
            return null;
        }
        int n=0;
        ListNode cur1=node1;
        ListNode cur2=node2;
        while (cur1!=null){
            n++;
            cur1=cur1.next;
        }
        while (cur2!=null){
            n--;
            cur2=cur2.next;
        }
        //这里判断最后结点是否相同，不想同直接返回，若相同继续查找相交结点
        if(cur1!=cur2){
            return null;
        }
        ListNode head1=n>0?node1:node2;
        ListNode head2=head1==node1?node2:node1;
        n=Math.abs(n);
        while (n!=0){
            n--;
            head1=head1.next;
        }
        while (head1!=head2){
            head1=head1.next;
            head2=head2.next;
        }
        return head1;
    }

    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        node1.next=new ListNode(2);
        node1.next.next=new ListNode(3);
        node1.next.next.next=new ListNode(4);
        node1.next.next.next.next=new ListNode(5);
        node1.next.next.next.next.next=new ListNode(6);
        ListNode node2=new ListNode(4);
        node2.next=new ListNode(5);
        node2.next.next=new ListNode(6);
        System.out.println(findCommonNode(node1,node2).val);
    }
}
