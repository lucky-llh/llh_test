package com.test.llh.Tree;

import java.util.HashMap;
import java.util.Stack;
import java.util.Timer;

/**
 * 构造数组的MaxTree:
 * 已知：1.数组中没有重复的元素，将数组中的元素构造成一颗二叉树，数组中的每个值对应一个二叉树节点
 * 2.包括maxtree树在内且在其中的每一棵子树上，值最大的节点都是树的头。时间复杂度及空间复杂度都为O(n)
 *
 */
public class GetMaxTree {
    /**
     * 思路：1.首先找出每一个值左边第一个比他大的数以及右边第一个比他大的数
     * 2.构造原则：1.每一个数的父节点是它左边第一个比它大的数和它右边第一个比它大的数中，较小的那个
     *           2.如果一个数左边没有比它大的右边也没有比它大的，说明他是数组的最大值，即为树的根节点
     * 3.在寻找每一个结点左边最大及右边最大时可以借助栈，使栈从栈低到栈顶保持递减顺序
     * @param arr
     * @return
     */
    public static TreeNode getMaxTreeByArr(int[]arr){
        TreeNode[]tArr=new TreeNode[arr.length];
        for (int i=0;i<arr.length;i++){
            tArr[i]=new TreeNode(arr[i]);
        }
        Stack<TreeNode>stack=new Stack<>();
        HashMap<TreeNode,TreeNode>lBigMap=new HashMap<>();
        HashMap<TreeNode,TreeNode>rBigMap=new HashMap<>();
        for (int i=0;i<tArr.length;i++){
            while (!stack.isEmpty()&&stack.peek().val<tArr[i].val){
                popStackPutMap(stack,lBigMap);
            }
            stack.push(tArr[i]);
        }
        while (!stack.isEmpty()){
            popStackPutMap(stack,lBigMap);
        }
        for (int i=tArr.length-1;i!=-1;i--){
            while (!stack.isEmpty()&&stack.peek().val<tArr[i].val){
                popStackPutMap(stack,rBigMap);
            }
            stack.push(tArr[i]);
        }
        while (!stack.isEmpty()){
            popStackPutMap(stack,rBigMap);
        }
        TreeNode head=null;
        for (int i=0;i<tArr.length;i++){
            TreeNode curNode=tArr[i];
            //找到左边第一个比该节点大的结点
            TreeNode left=lBigMap.get(curNode);
            //找到右边第一个比该节点大的结点
            TreeNode right=rBigMap.get(curNode);
            if (left==null&&right==null){
                head=curNode;
            }else if (left==null){
                if (right.left==null){
                    right.left=curNode;
                }else{
                    right.right=curNode;
                }
            }else if (right==null){
                if (left.left==null){
                    left.left=curNode;
                }else{
                    left.right=curNode;
                }
            }else{
                TreeNode parent=left.val<right.val?left:right;
                if (parent.left==null){
                    parent.left=curNode;
                }else {
                    parent.right=curNode;
                }
            }
        }
        return head;
    }
    //设置左边比他大的数放到map中
    public static void popStackPutMap(Stack<TreeNode>stack,HashMap<TreeNode,TreeNode>map){
        TreeNode node=stack.pop();
        if (stack.isEmpty()){
            map.put(node,null);
        }else {
            map.put(node,stack.peek());
        }
    }

    /**
     * 非递归先序遍历一颗树
     * @param node
     */
    public static void prePrintByUnRec(TreeNode node){
        if (node==null){
            return;
        }
        Stack<TreeNode>stack=new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            node=stack.pop();
            System.out.println(node.val);
            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }

    }

    public static void main(String[] args) {
        int[]arr={3,4,5,1,2};
        TreeNode node=getMaxTreeByArr(arr);
        prePrintByUnRec(node);
    }
}
