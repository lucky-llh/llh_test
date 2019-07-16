package com.test.llh.Tree;

/**
 * 通过有序数组生成平衡二叉搜索树：
 * 可以使用递归实现，有序数组中间结点作为树的根节点，
 * 左半部分作为左子树，右半部分作为右子树
 */
public class GenerateTreeBySortTree {
    public TreeNode generateTree(int[]arr){
        if (arr==null||arr.length==0){
            return null;
        }
        return generate(arr,0,arr.length-1);
    }
    public TreeNode generate(int[]arr,int start,int end){
        if (start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode head=new TreeNode(mid);
        head.left=generate(arr,start,mid-1);
        head.right=generate(arr,mid+1,end);
        return head;
    }
}
