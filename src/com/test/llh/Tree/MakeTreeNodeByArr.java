package com.test.llh.Tree;

import java.util.HashMap;

/**
 * 1.将中序数组放入map中
 * 2.利用先序遍历的顺序构造二叉树
 * 3.先序数组中第一个元素为头结点，利用该值找到中序遍历数组中该值的位置然后分为左右两半即为左子树和右子树
 */
public class MakeTreeNodeByArr {
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if(pre==null||pre.length<0||in==null||in.length<0){
            return null;
        }
        //构造中序数组的map
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return process(pre,0,pre.length-1,in,0,in.length-1,map);
    }
    public static TreeNode process(int[]pre,int pi,int pj,int[]in,int ni,int nj,HashMap<Integer,Integer>map){
        if(pi>pj){
            return null;
        }
        TreeNode node=new TreeNode(pre[pi]);//头结点
        int index=map.get(pre[pi]);//头结点在中序数组中的位置
        node.left=process(pre,pi+1,pi+index-ni,in,ni,index-1,map);
        node.right=process(pre,pi+index-ni+1,pj,in,index+1,nj,map);
        return node;
    }

    public static void main(String[] args) {
        int []pre={1,2,4,7,3,5,6,8};
        int []in={4,7,2,1,5,3,8,6};
        TreeNode node=reConstructBinaryTree(pre,in);
        System.out.println(node.val+" "+node.left.val+" "+node.left.left.val+" "+node.left.left.right.val+" "+node.right.val+" "+node.right.left.val+" "+node.right.right.val+" "+node.right.right.left.val);
    }
}