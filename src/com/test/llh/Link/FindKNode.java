package com.test.llh.Link;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKNode {
    //方法一
    public static ListNode findKNode(ListNode head,int k){
        if(head==null){
            return null;
        }
        ListNode node=head;
        while (node!=null){
            k--;
            node=node.next;
        }
        if(k>0){
            return null;//不存在倒数第k个节点
        }else if(k==0){
            return head;
        }else{
            node=head;//从头开始
            while (++k!=0){
                node=node.next;//当k==0时走到倒数第k个节点的前一个节点
            }
            head=node.next;
        }
        return head;
    }
    //方法二：先反转链表，记录反转后链表的证书第k个节点，最后返回前再把链表反转过来
    public static ListNode findKNodeByReverseNode(ListNode head,int k){
        if(head==null){
            return null;
        }
        ListNode node=reverseNodes(head);
        ListNode reverseNode=node;
        while (reverseNode!=null&&--k!=0){
            reverseNode=reverseNode.next;
        }
        reverseNodes(node);
        return reverseNode;
    }
    public static ListNode reverseNodes(ListNode node){
        ListNode pre=null;
        ListNode next=null;
        ListNode head=node;
        while (head!=null){
            next=head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(3);
        node.next.next.next=new ListNode(4);
        node.next.next.next.next=new ListNode(5);
        int k=3;
        ListNode head=findKNode(node,k);
        ListNode headByReverse=findKNodeByReverseNode(node,k);
        System.out.println(head.val+"===="+headByReverse.val);
    }
}
