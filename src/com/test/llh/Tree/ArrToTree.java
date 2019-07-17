package com.test.llh.Tree;

import java.util.HashMap;

/**
 * 先序后序中序数组两两组合重构二叉树
 */
public class ArrToTree {
    public TreeNode preAndInToTree(int[]pre,int []in){
        if (pre==null||in==null){
            return null;
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return preIn(pre,0,pre.length-1,in,0,in.length-1,map);
    }
    public TreeNode preIn(int[]pre,int pi,int pj,int[]n,int ni,int nj,HashMap<Integer,Integer>map){
        if (pi>pj){
            return null;
        }
        TreeNode head=new TreeNode(pre[pi]);
        int index=map.get(pre[pi]);
        head.left=preIn(pre,pi+1,pi+index-ni,n,ni,index-1,map);
        head.right=preIn(pre,pi+index-ni+1,pj,n,index+1,nj,map);
        return head;
    }
    public TreeNode inAndPostToTree(int[]in,int[]post){
        if (in==null||post==null){
            return null;
        }
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<in.length;i++){
            map.put(in[i],i);
        }
        return inPost(in,0,in.length-1,post,0,post.length-1,map);
    }
    public TreeNode inPost(int[]n,int ni,int nj,int[]post,int pi,int pj,HashMap<Integer,Integer>map){
        if (pi>pj){
            return null;
        }
        TreeNode node=new TreeNode(post[pj]);
        int index=map.get(post[pj]);
        node.left=inPost(n,ni,index-1,post,pi,pi+index-ni-1,map);
        node.right=inPost(n,index+1,nj,post,pi+index-ni,pj-1,map);
        return node;
    }
}
