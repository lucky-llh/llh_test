package com.test.llh.Tree;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 按层打印和之子形打印二叉树
 */
public class PrintByLevel {
    public static void printByLevel(TreeNode node){
        if (node==null){
            return;
        }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.offer(node);
        int level=1;
        TreeNode last=node;//记录当前行最后一个节点
        TreeNode nlast=null;//记录下一行最后一个结点
        System.out.print("Level"+(level++)+" :");
        while (!queue.isEmpty()){
            node=queue.poll();
            System.out.print(node.val+" ");
            if (node.left!=null){
                queue.offer(node.left);
                nlast=node.left;
            }
            if (node.right!=null){
                queue.offer(node.right);
                nlast=node.right;
            }
            if (node==last&&!queue.isEmpty()){
                last=nlast;
                System.out.print("\nLevel"+(level++)+" :");

            }
        }
        System.out.println();
    }

    /**
     * 之子形打印二叉树：
     * 原则：定义一个双端队列
     * 从左往右打印时，从队头出，若该节点有孩子结点，让其左右孩子从队尾入队
     * 从右往左打印时，从队尾出，若该节点有孩子节点，让其右左孩子从队头入队
     * 还是用last和nlast变量跟踪每次最后一个打印的结点
     * @param node
     */
    public static void printByZigZag(TreeNode node){
        if (node==null){
            return;
        }
        Deque<TreeNode>deque=new LinkedList<>();
        int level=1;
        boolean lr=true;
        deque.offerFirst(node);
        TreeNode last=node;
        TreeNode nlast=null;
        pringLevelAndOrientation(level++,lr);
        while (!deque.isEmpty()){
            if (lr){
                node=deque.pollFirst();
                if (node.left!=null){
                    deque.offerLast(node.left);
                    nlast=nlast==null?node.left:nlast;
                }
                if (node.right!=null){
                    deque.offerLast(node.right);
                    nlast=nlast==null?node.right:nlast;
                }
            }else{
                node=deque.pollLast();
                if (node.right!=null){
                    deque.offerFirst(node.right);
                    nlast=nlast==null?node.right:nlast;
                }
                if (node.left!=null){
                    deque.offerFirst(node.left);
                    nlast=nlast==null?node.left:nlast;
                }
            }
            System.out.print(node.val+" ");
            if (node==last&&!deque.isEmpty()){
                lr=!lr;
                last=nlast;
                nlast=null;
                System.out.println();
                pringLevelAndOrientation(level++,lr);
            }
        }
        System.out.println();
    }
    public static void pringLevelAndOrientation(int level,boolean lr){
        System.out.print("Level "+(level++)+" from ");
        System.out.print(lr?"left to rigth: ":"right to left: ");
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.right.left=new TreeNode(5);
        node.right.right=new TreeNode(6);
        node.right.left.left=new TreeNode(7);
        node.right.left.right=new TreeNode(8);
        printByZigZag(node);
    }
}
