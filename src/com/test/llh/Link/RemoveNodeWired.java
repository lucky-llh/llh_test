package com.test.llh.Link;

/**
 * 一种怪异的删除方式：给定要删除的结点，但不给出头结点，
 */
public class RemoveNodeWired {
    /**
     * 找到该结点的下一个节点，将下一个结点的值复制给当前节点，然后删除下一个节点
     * 问题：1.此方法不能删除最后一个结点
     * 2.这种方法本质上不是删除当前节点而是给当前节点复另外的值，在实际工程中可能会有问题
     * @param node
     */
    public void removeNode(ListNode node){
        if (node==null)return;
        ListNode next=node;
        if (next==null){
            throw new RuntimeException("can not remove last node");
        }
        node.val=next.val;
        node.next=next.next;
    }
}
