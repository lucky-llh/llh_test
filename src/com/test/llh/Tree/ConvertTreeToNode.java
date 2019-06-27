package com.test.llh.Tree;

import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * //二叉搜索树中序遍历是递增的
 */
public class ConvertTreeToNode {

    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        TreeNode node=pRootOfTree;
        TreeNode pre=null;
        boolean isFirst=true;
        Stack<TreeNode>stack=new Stack<>();
        while (!stack.isEmpty()||node!=null){
            //将左子树全部入栈
            while (node!=null){
                stack.push(node);
                node=node.left;
            }
            node=stack.pop();
            if(isFirst){
                pRootOfTree=node;//记录根节点
                pre=node;
                isFirst=false;
            }else{
                pre.right=node;
                node.left=pre;
                pre=node;
            }
            node=node.right;
        }
        return pRootOfTree;
    }
}
