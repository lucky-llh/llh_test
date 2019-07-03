package com.test.llh.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 按之字形顺序打印二叉树：
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintTreeZ {
    /**
     * 之字形打印：借助队列完成
     * 定义几个变量作为标识：last最为每一层最后一个打印的结点，nlast最为下一层最后一个打印的节点（第一个入队的结点），lr=true:从左到右打印
     * @param pRoot
     * @return
     */
    public static ArrayList<ArrayList<Integer>> printTree(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        if (pRoot==null){
            return res;
        }
        Deque<TreeNode>deque=new LinkedList<>();
        deque.add(pRoot);
        TreeNode last=pRoot;
        TreeNode nlast=null;
        boolean lr=true;
        ArrayList<Integer>list=new ArrayList<>();
        while (!deque.isEmpty()){
            if (lr){
                pRoot=deque.pollFirst();
                if (pRoot.left!=null){
                    deque.addLast(pRoot.left);
                    nlast=nlast==null?pRoot.left:nlast;
                }
                if (pRoot.right!=null){
                    deque.addLast(pRoot.right);
                    nlast=nlast==null?pRoot.right:nlast;
                }
                list.add(pRoot.val);
            }else{
                pRoot=deque.pollLast();
                if (pRoot.right!=null){
                    deque.addFirst(pRoot.right);
                    nlast=nlast==null?pRoot.right:nlast;
                }
                if (pRoot.left!=null){
                    deque.addFirst(pRoot.left);
                    nlast=nlast==null?pRoot.left:nlast;
                }
                list.add(pRoot.val);
            }
            if (pRoot==last){
                last=nlast;
                nlast=null;
                lr=!lr;
                res.add(list);
                list=new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(5);
        node.left=new TreeNode(3);
        node.right=new TreeNode(7);
        node.left.left=new TreeNode(2);
        node.left.right=new TreeNode(4);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(8);
        ArrayList<ArrayList<Integer>>res=printTree(node);
        res.stream().forEach(list -> {
            list.stream().forEach(System.out::println);
        });
    }
}
