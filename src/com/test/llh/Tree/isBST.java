package com.test.llh.Tree;

import java.util.Stack;

/**
 * 判断一棵树是否是二叉搜索树：
 * 中序遍历判断
 */
public class isBST {
    public boolean isBST(TreeNode node){
        if (node==null){
            return true;
        }
        Stack<TreeNode>stack=new Stack<>();
        boolean res=true;
        TreeNode pre=null;
        while (!stack.isEmpty()||node!=null){
            if (node!=null){
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop();
                if (pre!=null&&pre.val>node.val){
                    res=false;
                }
                pre=node;
                node=node.right;
            }
        }
        return res;
    }
}
