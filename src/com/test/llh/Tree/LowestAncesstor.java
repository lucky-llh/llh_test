package com.test.llh.Tree;

import sun.reflect.generics.tree.Tree;

/**
 * 二叉树中两个结点的最近公共祖先结点
 * 1.后序遍历
 * 2.如果node结点为空，或者是这两个结点中的其中一个，返回node
 * 3.若果左子树返回的结果为null,右子树也为null,说明左右子树都没有找到返回null
 * 4.如果都不为空，返回node,
 * 5.如果有一个为空，返回node
 */
public class LowestAncesstor {
    public TreeNode lowerAnc(TreeNode node,TreeNode o1,TreeNode o2){
        if (node==null||node==o1||node==o2){
            return node;
        }
        TreeNode left=lowerAnc(node.left,o1,o2);
        TreeNode right=lowerAnc(node.right,o1,o2);
        if (left!=null&&right!=null){
            return node;
        }
        return left!=null?left:right;
    }
}
