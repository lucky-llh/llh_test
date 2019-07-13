package com.test.llh.Link;

public class ListPartitionNode {
    /**
     * 方法1：借助数组实现
     * @param node
     * @param pivot
     * @return
     */
    public static ListNode listPartition(ListNode node,int pivot){
        if (node==null||node.next==null){
            return node;
        }
        ListNode cur=node;
        int len=0;
        while (cur!=null){
            len++;
            cur=cur.next;
        }
        //将链表放入数组中
        cur=node;
        ListNode[]nodeArr=new ListNode[len];
        for (int i=0;i!=len;i++){
            nodeArr[i]=cur;
            cur=cur.next;
        }
        //对数组进行patition
        partion(nodeArr,pivot);
        int i=1;
        for(i=1;i<nodeArr.length;i++){
            nodeArr[i-1].next=nodeArr[i];
        }
        nodeArr[i-1].next=null;
        return nodeArr[0];
    }
    public static void partion(ListNode[]arr,int pivot){
        int small=-1;
        int big=arr.length;
        int index=0;
        while (index!=big){
            if (arr[index].val<pivot){
                swap(arr,index++,++small);
            }else if (arr[index].val==pivot){
                index++;
            }else{
                swap(arr,index,--big);
            }
        }
    }
    public static void swap(ListNode[]arr,int i,int j){
        ListNode node=arr[i];
        arr[i]=arr[j];
        arr[j]=node;
    }

    /**
     * 方法二：划分后保持原有链表顺序不变
     * @param node
     * @param pivot
     * @return
     */
    public static ListNode  listPatition1(ListNode node,int pivot){
        ListNode eH=null;
        ListNode eT=null;
        ListNode sH=null;
        ListNode sT=null;
        ListNode bH=null;
        ListNode bT=null;
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
                }else {
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
        //拼接小的和相等的
        if (sT!=null){
            sT.next=eH;
            eT=eT==null?sT:eT;
        }
        //所有的重新连接
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
        ListNode cur=listPatition1(node,pivot);
        while (cur!=null){
            System.out.println(cur.val);
            cur=cur.next;
        }
    }
}
