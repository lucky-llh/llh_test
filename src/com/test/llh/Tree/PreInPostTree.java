package com.test.llh.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * 递归及非递归方式实现二叉树的中序，先序，后序遍历
 */
public class PreInPostTree {
    /**
     * 递归先序
     * @param node
     */
    public void preOrderRecur(TreeNode node){
        if (node==null){
            return;
        }
        System.out.print(node.val+" ");
        preOrderRecur(node.left);
        preOrderRecur(node.right);
    }

    /**
     * 递归中序
     * @param node
     */
    public void inOrderRecur(TreeNode node){
        if (node==null){
            return;
        }
        inOrderRecur(node.left);
        System.out.print(node.val+" ");
        inOrderRecur(node.right);
    }

    /**
     * 递归后序
     * @param node
     */
    public void postOrderRecur(TreeNode node){
        if (node==null){
            return;
        }
        postOrderRecur(node.left);
        postOrderRecur(node.right);
        System.out.print(node.val+" ");
    }

    /**
     * 非递归先序
     * @param node
     */
    public void preOrder(TreeNode node){
        if (node==null){
            return;
        }
        Stack<TreeNode>stack=new Stack();
        stack.push(node);
        while (!stack.isEmpty()){
            node=stack.pop();
            System.out.print(node.val+" ");
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
    }
    public void inOrder(TreeNode node){
        if (node==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        while (!stack.isEmpty()||node!=null){
            //先将左子树入栈
            if (node!=null){
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop();
                System.out.print(node.val+" ");
                //弹出在指向右子树
                node=node.right;
            }
        }
    }

    /**
     * 非递归后序：用两个栈实现
     * @param node
     */
    public void postOrder1(TreeNode node){
        if (node==null){
            return;
        }
        Stack<TreeNode>stack1=new Stack<>();
        Stack<TreeNode>stack2=new Stack<>();
        stack1.push(node);
        while (!stack1.isEmpty()){
            node=stack1.pop();
            stack2.push(node);
            if (node.left!=null){
                stack1.push(node.left);
            }
            if (node.right!=null){
                stack1.push(node.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.print(stack2.pop().val+" ");
        }
    }

    /**
     * 非递归后序：用一个栈实现，并定义两个变量，h指向最近弹出并打印的结点，c指向栈顶
     * @param node
     */
    public void postOrder2(TreeNode node){
        if (node==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        stack.push(node);
        TreeNode h=node;
        TreeNode c=null;
        while (!stack.isEmpty()){
            c=stack.peek();
            if (c.left!=null&&h!=c.left&&h!=c.right){
                stack.push(c.left);
            }else if (c.right!=null&&h!=c.right){
                stack.push(c.right);
            }else{
                System.out.print(stack.pop().val+" ");
                h=c;//最近弹出并打印的结点
            }
        }

    }
}
