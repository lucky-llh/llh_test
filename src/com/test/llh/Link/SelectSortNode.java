package com.test.llh.Link;

/**
 * 单链表的选择排序：额外空间复杂度为O(1)
 * 选择排序是找到未排序部分的最小值插入已排序的后面:
 * 所以对于链表保证在未排序部分删除最小值，并将其插入已排序的后面
 */
public class SelectSortNode {
    public static ListNode selectNode(ListNode node){
        if (node==null){
            return node;
        }
        ListNode tail=null;
        ListNode cur=node;
        ListNode small=null;
        ListNode smallPre=null;
        while (cur!=null){
            small=cur;
            smallPre=getSmallPreNode(cur);
            //删除smal结点
            if (smallPre!=null){
                small=smallPre.next;
                smallPre.next=small.next;
            }
            //如果当前结点就是最小值结点，结点后移动，否则不变
            cur=cur==small?cur.next:cur;
            //插入排序的尾部
            if (tail==null){
                node=small;
            }else {
                tail.next=small;
            }
            tail=small;
        }
        return node;
    }
    public static ListNode getSmallPreNode(ListNode node){
        ListNode cur=node.next;
        ListNode pre=node;
        ListNode small=node;
        ListNode smallPre=null;
        while (cur!=null){
            if (cur.val<small.val){
                small=cur;
                smallPre=pre;
            }
            pre=cur;
            cur=cur.next;
        }
        return smallPre;
    }

    public static void main(String[] args) {
        ListNode node=new ListNode(2);
        node.next=new ListNode(1);
        node.next.next=new ListNode(3);
        ListNode res=selectNode(node);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
}
