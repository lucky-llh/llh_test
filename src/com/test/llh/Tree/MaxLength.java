package com.test.llh.Tree;

/**
 * 二叉树最大路径和
 */
public class MaxLength {
    int max=Integer.MIN_VALUE;
    public int maxLength(TreeNode node){
        if (node==null){
            return 0;
        }
        maxLen(node);
        return max;
    }

    /**
     * 递归返回子树上的最大路径和
     * @param node
     * @return
     */
    public int maxLen(TreeNode node ){
        if (node==null)return 0;
        int left=Math.max(maxLen(node.left),0);
        int right=Math.max(maxLen(node.right),0);
        max=Math.max(max,left+right+node.val);
        return Math.max(left+node.val,right+node.val);
    }

}
