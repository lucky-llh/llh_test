package com.test.llh.Link;

/**
 * 判断链表是否有环,如果有返回入环结点，没有返回null
 */
public class IsLoopNode {
    /**
     * 主要使用快慢指针实现，快指针每次走两步，慢指针每次走一步，
     * 如果快指针提前遇到null指针，肯定是无环的，
     * 否则当快慢指针第一次相遇时，让快指针从头开始，每次走一步，再次相遇时就是入环的结点
     * @param node
     * @return
     */
    public static ListNode isLoopNode(ListNode node){
       if(node==null){
           return null;
       }
       ListNode slow=node.next;
       ListNode fast=node.next.next;
       while (slow!=fast){
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

    public static void main(String[] args) {
        ListNode node =new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        node.next.next.next.next.next=node.next.next;
        System.out.println(isLoopNode(node).val);
    }
}
