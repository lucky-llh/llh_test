package com.test.llh.Tree;

import sun.reflect.generics.tree.Tree;

/**
 * 判断t1树是否包含t2树全部的拓扑结构
 */
public class ContainsTree {
    public boolean contains(TreeNode node1,TreeNode node2){
        return check(node1,node2)||contains(node1.left,node2)||contains(node1.right,node2);
    }
    public boolean check(TreeNode head,TreeNode node){
        if (node==null){
            return true;
        }
        if (head==null||head.val!=node.val){
            return false;
        }
        return check(head.left,node.left)&&check(head.right,node.right);
    }
}
