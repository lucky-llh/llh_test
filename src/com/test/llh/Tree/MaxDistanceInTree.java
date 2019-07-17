package com.test.llh.Tree;

/**
 * 二叉树结点间的最大距离
 */
public class MaxDistanceInTree {
    public int maxTree(TreeNode node){
        int[]res=new int[1];
        return postOrder(node,res);
    }
    public int postOrder(TreeNode node,int[]res){
        if (node==null){
            res[0]=0;
            return 0;
        }
        int lMax=postOrder(node.left,res);
        int maxFromLeft=res[0];
        int rMax=postOrder(node.right,res);
        int maxFromRight=res[0];
        int curNodeMax=maxFromLeft+maxFromRight+1;
        res[0]=Math.max(maxFromLeft,maxFromRight)+1;
        return Math.max(Math.max(lMax,rMax),curNodeMax);
    }
}
