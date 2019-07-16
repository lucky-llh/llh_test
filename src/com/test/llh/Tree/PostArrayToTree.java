package com.test.llh.Tree;

import sun.reflect.generics.tree.Tree;

/**
 * 判断数组是否是二叉搜索树后序遍历的结果及根据后序数组构建二叉搜索树
 * 后序遍历最后一个元素为根节点，所以根据根节点遍历数组，把数组分为两部分，然后分别构建左右子树
 */
public class PostArrayToTree {
    public boolean isPostArr(int[]arr){
        if(arr==null||arr.length==0){
            return false;
        }
        return isPost(arr,0,arr.length-1);
    }
    public boolean isPost(int[]arr,int start,int end){
        if (start==end){
            return true;
        }
        int less=-1;
        int more=end;
        for (int i=0;i<end;i++){
            if (arr[end]>arr[i]){
                less=i;
            }else{
                more=more==end?i:more;
            }
        }
        //说明是左倾斜或者由倾斜
        if (less==-1||more==end){
            return isPost(arr,start,end-1);
        }
        //不相邻，说明不是
        if (less!=more-1){
            return false;
        }
        //否则继续分别递归判断左右部分
        return isPost(arr,start,less)&&isPost(arr,more,end-1);
    }
    public TreeNode postArrToBST(int[]arr){
        if (arr==null||arr.length==0){
            return null;
        }
        return makeTree(arr,0,arr.length-1);
    }
    public TreeNode makeTree(int[]arr,int start,int end){
        if (start>end){
            return null;
        }
        TreeNode head=new TreeNode(arr[end]);
        int less=-1;
        int more=end;
        for (int i=0;i<end;i++){
            if (arr[end]>arr[i]){
                less=i;
            }else {
                more=more==end?i:more;
            }
        }
        head.left=makeTree(arr,start,less);
        head.right=makeTree(arr,more,end);
        return head;
    }
}
