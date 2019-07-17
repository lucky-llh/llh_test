package com.test.llh.Link;

import com.test.llh.Tree.RandomListNode;

import java.util.HashMap;

public class CopyRandomList {
    /**
     * 方法1：借助hashMap实现,时间和空间复杂度O(N)
     * 将每一个节点作为key,节点的复制结点作为value放置到map中
     * @param node
     * @return
     */
    public RandomListNode copyNode(RandomListNode node){
        HashMap<RandomListNode,RandomListNode>map=new HashMap<>();
        RandomListNode cur=node;
        while (cur!=null){
            map.put(cur,new RandomListNode(cur.label));
        }
        cur=node;
        while (cur!=null){
            //复制结点的next就是当前节点的next对应的复制结点
            map.get(cur).next=map.get(cur.next);
            //复制结点的random就是当前节点random对应的复制结点
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(node);
    }

    /**
     * 不借助额外空间，直接使用有限变量实现：
     * 1.先将每个节点的复制结点放在其后面
     * 2.设置随机结点
     * 3.断开链表
     * @param node
     * @return
     */
    public static RandomListNode copyNode1(RandomListNode node){
        if (node==null||node.next==null){
            return node;
        }
        RandomListNode cur=node;
        //1.设置结点
        RandomListNode next=null;
        while (cur!=null){
            next=cur.next;
            cur.next=new RandomListNode(cur.label);
            cur.next.next=next;
            cur=next;
        }
        //2.设置随机结点
        RandomListNode copyNode=null;
        cur=node;
        while (cur!=null){
            next=cur.next.next;
            copyNode=cur.next;
            copyNode.random=cur.random==null?null:cur.random;
            cur=next;
        }
        //3.断开链表
        cur=node;
        RandomListNode head=cur.next;
        while (cur!=null){
            next=cur.next.next;
            copyNode=cur.next;
            copyNode.next=next==null?null:next.next;
            cur.next=next;
            cur=next;
        }
        return head;
    }

    public static void main(String[] args) {
        RandomListNode node=new RandomListNode(1);
        node.next=new RandomListNode(2);
        node.next.next=new RandomListNode(3);
        node.random=node.next.next;
        node.next.random=node;
        node.next.next.random=node.next;
        RandomListNode randomListNode=copyNode1(node);
        while (randomListNode!=null){
            System.out.print(randomListNode.random.label);
            randomListNode=randomListNode.next;
        }
    }
}
