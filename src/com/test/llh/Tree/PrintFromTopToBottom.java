package com.test.llh.Tree;

import java.util.*;

/**
 * 层次遍历：借助队列实现
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class PrintFromTopToBottom {
    public static ArrayList<Integer>printFromTopToBottom(TreeNode root){
        ArrayList<Integer>list=new ArrayList<>();
        if(root==null){
            return list;
        }else{
            Queue<TreeNode>queue=new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                root=queue.poll();
                list.add(root.val);
                if (root.left!=null){
                    queue.add(root.left);
                }
                if (root.right!=null){
                    queue.add(root.right);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);
       ArrayList list= printFromTopToBottom(node);
       Iterator<Integer>iterator=list.iterator();
       while (iterator.hasNext()){
           System.out.print(iterator.next()+" ");
       }


    }
}
