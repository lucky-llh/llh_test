package com.test.llh.Tree;

import java.util.Stack;

/**
 *判断一颗二叉树是否是对称的：
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class IsSymmetricalTree {
    /**
     * 对称的二叉树：左子树的左边和右子树的右边相同以及左子树的右边和右子树的左边相同
     * 1.递归和非递归实现（借助自定义栈）
     * @param node
     * @return
     */
    public static boolean isSymmeTree(TreeNode node){
        if (node==null){
            return true;
        }
        return process(node.left,node.right);
    }
    public static boolean process(TreeNode left,TreeNode right){
        if (left==null&&right==null){
            return true;
        }
        if (left==null||right==null){
            return false;
        }
        if (left.val!=right.val){
            return false;
        }
        return process(left.left,right.right)&&process(left.right,right.left);
    }
    public static boolean isSymmeTreeByUnRec(TreeNode node){
        if (node==null){
            return true;
        }
        Stack<TreeNode>stack=new Stack<>();
        stack.push(node.left);
        stack.push(node.right);
        while (!stack.isEmpty()){
            TreeNode right=stack.pop();
            TreeNode left=stack.pop();
            if (left==null&&right==null){
                continue;
            }
            if (left==null||right==null){
                return false;
            }
            if (left.val!=right.val){
                return false;
            }
            stack.push(left.left);
            stack.push(right.right);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }

    public static void main(String[] args) {
      //  TreeNode node=null;
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(2);
        node.left.left=new TreeNode(3);
        node.left.right=new TreeNode(4);
        node.right.left=new TreeNode(4);
        node.right.right=new TreeNode(3);
        System.out.println(isSymmeTreeByUnRec(node));
    }
}
