package com.test.llh.Link;

/**
 * 打印两个有序链表的公共部分
 */
public class PrintCommonPartInSortNode {
    public void printComNode(ListNode node1,ListNode node2){
        while (node1!=null&&node2!=null){
            if (node1.val<node2.val){
                node1=node1.next;
            }else if (node1.val>node2.val){
                node2=node2.next;
            }else{
                System.out.print(node1.val+" ");
                node1=node1.next;
                node2=node2.next;
            }
        }
    }
}
