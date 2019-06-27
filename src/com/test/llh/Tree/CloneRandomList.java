package com.test.llh.Tree;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class CloneRandomList{
    /**
     * 一、复制结点，将node'结点放在node结点后面
     * 二、复制随机结点 ，node'结点的随机节点为node对应的随机结点即 加入1.random=3,则1‘.random=3'
     * 三、断开结点
     * @param pHead
     * @return
     */
    public static RandomListNode cloneRandomList(RandomListNode pHead){
        if(pHead==null){
            return null;
        }
        //1.复制结点
        RandomListNode node=pHead;
        RandomListNode next=null;
        while (node!=null){
            next=node.next;
            node.next=new RandomListNode(node.label);
            node.next.next=next;
            node=next;
        }
        //2.复制随机结点
        node=pHead;
        RandomListNode copyNode=null;
        while(node!=null){
            next=node.next.next;
            copyNode=node.next;
            copyNode.random=node.random==null?null:node.random.next;
            node=next;
        }
        //3.断开链表
        RandomListNode copyHead=pHead.next;
        node=pHead;
        while(node!=null){
            next=node.next.next;
            copyNode=node.next;
            copyNode.next=next==null?null:next.next;
            node.next=next;
            node=next;
        }
        return copyHead;
    }

    public static void main(String[] args) {
        RandomListNode node=new RandomListNode(1);
        node.next=new RandomListNode(2);
        node.next.next=new RandomListNode(3);
        node.random=node.next.next;
        node.next.random=node;
        node.next.next.random=node.next;
        RandomListNode randomListNode=cloneRandomList(node);
        while (randomListNode!=null){
            System.out.print(randomListNode.label);
            randomListNode=randomListNode.next;
        }
    }
}
