package com.test.llh.Tree;

import java.util.Stack;

/**
 * 找到二叉搜索树中两个错误结点
 * 二叉搜索树中序遍历是递增的，所以可以利用中序遍历找出错误结点，
 * 如果有两个结点肯定会出现两次降序，第一个错误结点是第一次降序中较大的，第二个错误结点是第二次降序中较小的结点
 */
public class GetTwoErroNode {
    public static TreeNode [] getTwoErroNode(TreeNode node){
        if (node==null){
            return null;
        }
        TreeNode[]res=new TreeNode[2];
        Stack<TreeNode>stack=new Stack<>();
        TreeNode pre=null;
        while (!stack.isEmpty()||node!=null){
            if (node!=null){
                stack.push(node);
                node=node.left;
            }else {
                node=stack.pop();
                if (pre!=null&&pre.val>node.val){
                    res[0]=res[0]==null?pre:res[0];
                    res[1]=node;
                }
                pre=node;
                node=node.right;
            }
        }
        return res;
    }
}
