package com.test.llh.Tree;

/***
 * 判断二叉树是否是平衡二叉树：
 * 任何结点左右子树高度差不超过1
 * 利用后序遍历统计，先遍历左子树统计左子树最深到那一层，以及左子树是否为平衡树，如果不是直接返回false,否则遍历右子树
 * 当左右子树都为平衡树时，再看整体是否为平衡树
 */
public class IsBalanceTree {
    public boolean isBalance(TreeNode node){
        boolean[]res=new boolean[1];
        res[0]=true;
        getHeight(node,1,res);
        return res[0];
    }
    public int getHeight(TreeNode node,int level,boolean[]res){
        if (node==null){
            return level;
        }
        int lh=getHeight(node.left,level+1,res);
        if (!res[0]){
            return level;
        }
        int rh=getHeight(node.right,level+1,res);
        if (!res[0]){
            return level;
        }
        if (Math.abs(lh-rh)>1){
            res[0]=false;
        }
        return Math.max(lh,rh);
    }

}
