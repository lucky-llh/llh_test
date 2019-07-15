package com.test.llh.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化及反序列化二叉树
 */
public class SerialAndReconTree {
    /**
     * 利用先序遍历序列化一棵树
     * 1.首先定义一个字符串str="";
     * 2.遇到null结点时，记为#！
     * 3.否则记为val!
     * @param node
     * @return
     */
    public static String seriaTreeByPre(TreeNode node){
        if (node==null){
            return "#!";
        }
        String str=node.val+"!";
        str+=seriaTreeByPre(node.left);
        str+=seriaTreeByPre(node.right);
        return str;
    }

    /**
     * 先序反序列化一个二叉树
     * @param str
     * @return
     */
    public static TreeNode reconTreeByPre(String str){
        String[]arr=str.split("!");
        Queue<String>queue=new LinkedList<>();
        for (int i=0;i<arr.length;i++){
            queue.offer(arr[i]);
        }
        return reconTreeByPreOrder(queue);
    }
    public static TreeNode reconTreeByPreOrder(Queue<String>queue){
        String value=queue.poll();
        if (value.equals("#")){
            return null;
        }
        TreeNode node=new TreeNode(Integer.valueOf(value));
        node.left=reconTreeByPreOrder(queue);
        node.right=reconTreeByPreOrder(queue);
        return node;
    }

    /**
     * 层次遍历序列化一颗树
     * @param node
     * @return
     */
    public static String serialTreeByLevel(TreeNode node){
        if (node==null){
            return "#!";
        }
        String str=node.val+"!";
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            node=queue.poll();
            if (node.left!=null){
                queue.offer(node.left);
                str+=node.left.val+"!";
            }else {
                str+="#!";
            }
            if (node.right!=null){
                queue.offer(node.right);
                str+=node.right.val+"!";
            }else {
                str+="#!";
            }
        }
        return str;
    }
    public static TreeNode reconTreeByLevel(String str){
       String[]value= str.split("!");
       int index=0;
       TreeNode head=generateNodeByValue(value[index++]);
       Queue<TreeNode>queue=new LinkedList<>();
       if (head!=null){
           queue.offer(head);
       }
       TreeNode node=null;
       while (!queue.isEmpty()){
           node=queue.poll();
           node.left=generateNodeByValue(value[index++]);
           node.right=generateNodeByValue(value[index++]);
           if (node.left!=null){
               queue.offer(node.left);
           }
           if (node.right!=null){
               queue.offer(node.right);
           }
       }
       return head;
    }
    public static TreeNode generateNodeByValue(String str){
        if (str.equals("#")){
            return null;
        }
        return new TreeNode(Integer.valueOf(str));
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        String pre=seriaTreeByPre(node);
        String level=serialTreeByLevel(node);
        System.out.println(pre+"======"+level);
    }
}
