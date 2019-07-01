package com.test.llh.Tree;


import sun.plugin2.gluegen.runtime.CPU;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度：输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度
 */
public class TreeDepth {
    public static int treeDepth(TreeNode node){
        if(node==null){
            return 0;
        }
        int count=0;
        int nextCount=1;//记录每一层的结点个数，初始为第一层的个数
        int depth=0;//用来记录树的深度
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            node=queue.poll();
            count++;
            if (node.left!=null){
                queue.add(node.left);
            }
            if (node.right!=null){
                queue.add(node.right);
            }
            if (count==nextCount){
                nextCount=queue.size();
                count=0;
                depth++;
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);
        System.out.println(treeDepth(node));
    }
}
