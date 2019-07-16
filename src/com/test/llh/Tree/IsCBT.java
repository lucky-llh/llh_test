package com.test.llh.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一颗二叉树是否是完全二叉树:
 * 使用层次遍历：
 * 1.如果某个结点有右孩子没有左孩子，返回false;
 * 2.如果当前节点不是左右孩子都有，那之后的结点必须都是叶子节点，否则返回false;
 * 3.中间过程没有返回false,最后就返回true
 */
public class IsCBT {
    public boolean isCBT(TreeNode node){
        if (node==null){
            return true;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        boolean isleaf=false;
        queue.offer(node);
        TreeNode left=null;
        TreeNode right=null;
        while (!queue.isEmpty()){
            node=queue.poll();
            left=node.left;
            right=node.right;
            if ((isleaf&&(left!=null||right!=null))||(left==null&&right!=null)){
                return false;
            }
            if (left!=null){
                queue.offer(left);
            }
            if (right!=null){
                queue.offer(right);
            }else {
                isleaf=true;//开启叶子节点
            }
        }
        return true;
    }
}
