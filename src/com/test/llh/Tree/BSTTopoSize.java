package com.test.llh.Tree;

import sun.reflect.generics.tree.Tree;

/**
 * 找到二叉树中符合搜索二叉树条件的最大拓扑结构
 */
public class BSTTopoSize {
    public int bstTopoSize(TreeNode node){
        if (node==null){
            return 0;
        }
        int max=maxTopo(node,node);
        max=Math.max(max,bstTopoSize(node.left));
        max=Math.max(max,bstTopoSize(node.right));
        return max;
    }
    public int maxTopo(TreeNode head,TreeNode node){
        if (head!=null&&node!=null&&isBSTNode(head,node,node.val)){
            return maxTopo(head,node.left)+maxTopo(head,node.right)+1;
        }
        return 0;
    }
    public boolean isBSTNode(TreeNode head,TreeNode node,int val){
        if (head==null){
            return false;
        }
        if (head==node){
            return true;
        }
        return isBSTNode(head.val>val?head.left:head.right,node,val);
    }
}
