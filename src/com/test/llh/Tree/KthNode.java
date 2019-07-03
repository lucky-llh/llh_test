package com.test.llh.Tree;

import java.util.Stack;

/**
 * 二叉搜索树的第k个结点：
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class KthNode {
    /**
     * 二叉搜索树中序遍历是递增的，所以可以借助中序遍历实现
     * @param node
     * @param k
     * @return
     */
    public static TreeNode kThNode(TreeNode node,int k){
        if (node==null||k==0){
            return null;
        }
        int count=0;
        Stack<TreeNode>stack=new Stack<>();
        while (!stack.isEmpty()||node!=null){
            if (node!=null){
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop();
                count++;
                if (count==k){
                    return node;
                }
                node=node.right;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(5);
        node.left=new TreeNode(3);
        node.right=new TreeNode(7);
        node.left.left=new TreeNode(2);
        node.left.right=new TreeNode(4);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(8);
        TreeNode res=kThNode(node,3);
        System.out.println(res.val);
    }
}
