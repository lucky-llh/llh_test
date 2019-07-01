package com.test.llh.Tree;

import java.util.logging.Level;

/**
 * 判断一颗二叉树是否是平衡二叉树
 */
public class IsBalancedTree {
    public static boolean isBalanced(TreeNode node){
        return  getDepth(node)!=-1;
    }
    public static int getDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int left=getDepth(node.left);
        if(left==-1){
            return -1;
        }
        int right=getDepth(node.right);
        if(right==-1){
            return -1;
        }
        return Math.abs(left-right)>1?-1:Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        System.out.println(isBalanced(node));
    }
}
