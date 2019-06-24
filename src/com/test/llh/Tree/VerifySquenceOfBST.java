package com.test.llh.Tree;

import java.security.PublicKey;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * //1.二叉搜索树特点：左子树节点值<根节点值<右子树节点值
 * //2.二叉搜索树中序遍历是递增序列
 * //3.后续遍历二叉搜索树，最后一个元素是根节点，可以根据根节点将数组分为两部分：左边部分的值都小于根节点的值，右半部分的值都大于根节点的值
 *   每一部分都满足此特性就是后续遍历的数组
 */
public class VerifySquenceOfBST {

    public static boolean verifySquenceOfBST(int [] arr) {
       if(arr==null||arr.length==0){
           return false;
       }
        return process(arr,0,arr.length-1);
    }
    public static boolean process(int[]arr,int left,int right){
        //判断结束都没出现异常情况，就返回true
        if(right-left<=0){
            return true;
        }
        int i=0;
        //找到第一个比根节点大的元素，从该元素起为树的右半部分
        for(i=0;i<right;i++){
            if(arr[i]>arr[right]){
                    break;
            }
        }
        for(int j=i;j<right;j++){
            if(arr[j]<arr[right]){
                return false;
            }
        }
        boolean lt=true;
        boolean rt=true;
        if(i>0){
            lt=process(arr,left,i-1);
        }
        if(i<right){
            rt=process(arr,i,right-1);
        }
        return lt&&rt;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(4);
        node.left=new TreeNode(2);
        node.right=new TreeNode(6);
        node.left.left=new TreeNode(1);
        node.left.right=new TreeNode(3);
        node.right.left=new TreeNode(5);
        node.right.right=new TreeNode(7);
        int arr[]={1,3,2,5,7,6,4};
        System.out.print(verifySquenceOfBST(arr));
    }
}
