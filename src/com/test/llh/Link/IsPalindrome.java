package com.test.llh.Link;

import java.util.List;
import java.util.Stack;

/**
 * 判断链表是否为回文结构:
 * 三种方法：1.栈实现，将元素全部入栈，然后遍历链表，判断链表中结点和栈中对应的结点是否一致，若不一致则不是回文结构
 * 2.栈实现，将部分元素入栈，将链表中的右半部分入栈，然后比较左边部分与栈中元素是否一致
 * 3.利用几个变量实现
 */
public class IsPalindrome {
    /**
     * 方法1：将全部元素入栈
     * @param node
     * @return
     */
    public static boolean isPalindrome1(ListNode node){
        Stack<ListNode>stack=new Stack<>();
        ListNode cur=node;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (node!=null){
            if (node.val!=stack.pop().val){
                return false;
            }
            node=node.next;
        }
        return true;
    }

    /**
     * 方法2：将右半部分入栈
     * @param node
     * @return
     */
    public static boolean isPalindrome2(ListNode node){
        if (node==null||node.next==null){
            return true;
        }
        Stack<ListNode>stack=new Stack<>();
        ListNode cur=node;
        //right记录右半部分第一个结点
        ListNode right=node.next;
        while (cur.next!=null&&cur.next.next!=null){
            right=right.next;
            cur=cur.next.next;
        }
        while (right!=null){
            stack.push(right);
            right=right.next;
        }
        while (!stack.isEmpty()){
            if (node.val!=stack.pop().val){
                return false;
            }
            node=node.next;
        }
        return true;
    }

    /**
     * 方法3：利用变量实现：
     * 将右半部分反转，然后左右加逼，比较元素是否相等，若出现不相等的情况就返回false
     * @param node
     * @return
     */
    public static boolean isPalindrome3(ListNode node){
        if (node==null||node.next==null){
            return true;
        }
        ListNode node1=node;
        ListNode node2=node;
        while (node2.next!=null&&node2.next.next!=null){
            node1=node1.next;
            node2=node2.next.next;
        }
        //右半部分第一个结点（反转前）
        node2=node1.next;
        node1.next=null;
        ListNode node3=null;
        while (node2!=null){
            node3=node2.next;
            node2.next=node1;
            node1=node2;
            node2=node3;
        }
        node3=node1;//保存最后一个节点
        node2=node;//左边头结点
        boolean res=true;
        while (node1!=null&&node2!=null){
            if (node1.val!=node2.val){
                res=false;
                break;
            }
            node1=node1.next;
            node2=node2.next;
        }
        //恢复链表
        node1=node3.next;
        node3.next=null;
        while (node1!=null){
            node2=node1.next;
            node1.next=node3;
            node3=node1;
            node1=node2;
        }
        return res;
    }
    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        node.next=new ListNode(2);
        node.next.next=new ListNode(1);
        System.out.println(isPalindrome1(node)+" "+isPalindrome2(node)+" "+isPalindrome3(node));
    }
}
