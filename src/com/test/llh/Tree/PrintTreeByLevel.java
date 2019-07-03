package com.test.llh.Tree;

import com.test.llh.Link.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 把二叉树打印成多行：
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintTreeByLevel {
    /**
     * 层次遍历：queue实现
     * last记录当前行的最后一个元素
     * nlast记录下一行的最后一个元素，跟踪每一行最后入队的元素
     * 当node为每一行的最后一个节点（node==last)时，将这行数据放入结果集中，并领last=nlast(跟踪下一行的最后一个元素）
     * @param node
     * @return
     */
    public static ArrayList<ArrayList<Integer>> printTreeByLevel(TreeNode node){
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        if (node==null){
            return res;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(node);
        TreeNode last=node;
        TreeNode nlast=null;
        ArrayList<Integer>list=new ArrayList<>();
        while (!queue.isEmpty()){
            node=queue.poll();
            if (node.left!=null){
                queue.add(node.left);
                nlast=node.left;
            }
            if (node.right!=null){
                queue.add(node.right);
                nlast=node.right;
            }
            list.add(node.val);
            if (last==node){
                last=nlast;
                res.add(list);
                list=new ArrayList<>();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);
        ArrayList<ArrayList<Integer>>res=printTreeByLevel(node);
        res.stream().forEach(list->{
            list.stream().forEach(System.out::println);
        });
    }
}
