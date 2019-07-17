package com.test.llh.Tree;

/**
 * 统计完全二叉树的结点数：
 * 可以根据完全二叉树的特点加快求解速度
 * 先统计出完全二叉树的高度，然后看右子树是否达到最后一层，若达到，说明左子树是满儿叉，可以用公式求解，对右子树用递归方式继续求解
 * 若右子树没有到达最后一层，说明右子树是满儿叉，对左子树进行递归求解
 */
public class NodeNumInBCT {
    public int nodeNum(TreeNode node){
        if (node==null){
            return 0;
        }
        return count(node,1,mostLeftLevel(node,1));
    }
    public int count(TreeNode node,int level,int height){
        if (level==height){
            return 1;
        }
        if (mostLeftLevel(node.right,level+1)==height){
            return 1<<(height-1)+count(node.right,level+1,height);
        }else {
            return 1<<(height-level-1)+count(node.left,level+1,height);
        }
    }
    public int mostLeftLevel(TreeNode node,int level){
        while (node!=null){
            level++;
            node=node.left;
        }
        return level-1;
    }
}
