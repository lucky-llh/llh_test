package com.test.llh.Tree;

import org.omg.PortableInterceptor.INACTIVE;
import sun.reflect.generics.tree.Tree;

/**
 * 最大的二叉搜索树：
 * 有两种情况：
 * 1.要么整颗树时二叉搜索树
 * 2.要么来自左子树上或者右子树上
 *
 * 整颗树是二叉搜索树需满足：左子树的最大二叉搜索树的根节点是根节点的左孩子，右子树同理，并且左子树的最大值小于根节点，右子树的最小值大于根节点
 * 所以可以使用后序遍历，每次遍历统计信息：左子树最大二叉搜索树的根节点，最大值，最小值，节点个数
 */
public class BiggestSubBST {
    public TreeNode biggestBST(TreeNode node){
        int []record=new int[3];
        return posOrder(node,record);
    }
    public TreeNode posOrder(TreeNode node,int[]record){
        if (node==null){
            record[0]=0;
            record[1]=Integer.MAX_VALUE;
            record[2]=Integer.MIN_VALUE;
            return null;
        }
        TreeNode left=node.left;
        TreeNode right=node.right;
        int value=node.val;
        TreeNode lbst=posOrder(node.left,record);
        int lSize=record[0];
        int lMin =record[1];
        int lMax=record[2];
        TreeNode rbst=posOrder(node.right,record);
        int rSize=record[0];
        int rMin=record[1];
        int rMax=record[2];
        record[1]=Math.min(lMin,value);
        record[2]=Math.max(rMax,value);
        if (left==lbst&&right==rbst&&lMax<value&&rMin>value){
            record[0]=lSize+rSize+1;
            return node;
        }
        record[0]=Math.max(lSize,rSize);
        return lSize>rSize?lbst:rbst;
    }
}
