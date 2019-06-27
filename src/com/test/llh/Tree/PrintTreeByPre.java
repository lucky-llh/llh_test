package com.test.llh.Tree;

import java.util.Stack;

/**
 * 前序遍历一颗树：递归和非递归实现
 */
public class PrintTreeByPre {
    /**
     * 递归实现
     * @param node
     */
    public static void printTreeByRecur(TreeNode node){
        if(node==null){
            return;
        }
        System.out.print(node.val+" ");
        printTreeByRecur(node.left);
        printTreeByRecur(node.right);
    }

    /**
     * 非递归：借助栈实现
     * @param node
     */
    public static void printTreeByUnRecur(TreeNode node){
        if(node==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            node=stack.pop();
            System.out.print(node.val+" ");
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(5);
        node.left=new TreeNode(3);
        node.right=new TreeNode(7);
        node.left.left=new TreeNode(2);
        node.left.right=new TreeNode(4);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(8);
        printTreeByRecur(node);
        System.out.println();
        printTreeByUnRecur(node);
    }
}
