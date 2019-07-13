package com.test.llh.Link;

import java.util.HashSet;

/**
 * 删除单链表中重复的结点：重复结点只保留一个
 */
public class RemoveNode {
    /**
     * 方法1：借助hash实现，将元素放入hashset中，放入之前先判断
     * @param node
     * @return
     */
    public static void removeNodeByHash(ListNode node){
        if(node==null){
            return;
        }
        HashSet<Integer>set=new HashSet<>();
        ListNode pre=node;
        ListNode cur=node.next;
        set.add(node.val);
        while (cur!=null){
            if (set.contains(cur.val)){
                pre.next=cur.next;
            }else{
                set.add(cur.val);
                pre=cur;
            }
            cur=cur.next;
        }
    }

    /**
     * 利用类似选择排序方法：时间复杂度O(N2)
     * @param node
     */
    public static void removeNode(ListNode node){
        if (node==null){
            return;
        }
        ListNode cur=node;
        ListNode pre=null;
        ListNode next=null;
        while (cur!=null){
            pre=cur;
            next=cur.next;
            while (next!=null){
                if (cur.val==next.val){
                    pre.next=next.next;
                }else{
                    pre=next;
                }
                next=next.next;
            }
            cur=cur.next;
        }
    }

    /**
     * 删除重复元素，并且不保留重复元素
     * 1-2-3-3-4:1-2-4
     * @param node
     * @return
     */
    public static ListNode removeNode1(ListNode node){
        if (node==null){
            return node;
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
                    node=cur.next;//记录头结点
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
        node.next=new ListNode(1);
        node.next.next=new ListNode(2);
        node.next.next.next=new ListNode(3);
        node.next.next.next.next=new ListNode(4);
        ListNode node1=removeNode1(node);
        while (node1!=null){
            System.out.println(node1.val);
            node1= node1.next;
        }
    }

}
