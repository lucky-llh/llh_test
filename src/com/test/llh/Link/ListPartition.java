package com.test.llh.Link;


import java.util.List;

/**
 * 将单向链表按某值划分成左边小，中间相等，右边大的形式：要求时间复杂度O(N),空间复杂度O(N)，调整后元素的顺序无要求
 * 进阶：要求空间复杂度为O(1),并且元素之间的顺序保持不变
 */
public class ListPartition {
    /**
     * 1
     * @param node
     * @param pivot
     * @return
     */
    public static ListNode listPartition(ListNode node,int pivot){
        if (node==null){
            return node;
        }
        int n=0;
        ListNode cur=node;
        while (cur!=null){
            n++;
            cur=cur.next;
        }
        //生成一个node数组
        ListNode[]nodesArr=new ListNode[n];
        cur=node;
        for (int i=0;i<n;i++){
            nodesArr[i]=cur;
            cur=cur.next;
        }
        arrPartition(nodesArr,pivot);
        int i=1;
        for (i=1;i<nodesArr.length;i++){
            nodesArr[i-1].next=nodesArr[i];
        }
        nodesArr[i-1].next=null;
        return nodesArr[0];
    }
    public static void arrPartition(ListNode[]arr,int val){
        int small=-1;
        int big=arr.length;
        int index=0;
        while (index!=big){
            if (arr[index].val<val){
                swap(arr,++small,index++);
            }else if (arr[index].val==val){
                index++;
            }else {
                swap(arr,--big,index);
            }
        }
    }
    public static void swap(ListNode[]arr,int i,int j){
        ListNode temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static ListNode listPartitionNode(ListNode node,int pivot){
        if (node==null){
            return node;
        }
        ListNode sH=null;
        ListNode sT=null;
        ListNode eH=null;
        ListNode eT=null;
        ListNode bH=null;
        ListNode bT=null;
        //保存下一个节点
        ListNode next=null;
        while (node!=null){
            next=node.next;
            node.next=null;
            if (node.val<pivot){
                if (sH==null){
                    sH=node;
                    sT=node;
                }else{
                    sT.next=node;
                    sT=node;
                }
            }else if (node.val==pivot){
                if (eH==null){
                    eH=node;
                    eT=node;
                }else{
                    eT.next=node;
                    eT=node;
                }
            }else{
                if (bH==null){
                    bH=node;
                    bT=node;
                }else {
                    bT.next=node;
                    bT=node;
                }
            }
            node=next;
        }
        //拼接
        if (sT!=null){
            sT.next=eH;
            eT=eT==null?sT:eT;
        }
        if (eT!=null){
            eT.next=bH;
        }
        return sH!=null?sH:eH!=null?eH:bH;
    }
    public static void main(String[] args) {
        ListNode node=new ListNode(9);
        node.next=new ListNode(0);
        node.next.next=new ListNode(4);
        node.next.next.next=new ListNode(5);
        node.next.next.next.next=new ListNode(1);
        int pivot=3;
        ListNode cur=listPartitionNode(node,pivot);
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
