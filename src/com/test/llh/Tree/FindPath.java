package com.test.llh.Tree;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class FindPath {

    public static ArrayList<ArrayList<Integer>>res=new ArrayList<>();
    public static ArrayList<Integer>list=new ArrayList<>();

    /**
     * 方法一：深度遍历
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root==null){
            return res;
        }
        list.add(root.val);
        target-=root.val;
        if(target==0&&root.right==null&&root.left==null){
            res.add(new ArrayList<>(list));
        }
        if(root.left!=null){
            FindPath(root.left,target);
        }
        if(root.right!=null){
            FindPath(root.right,target);
        }
        //深度遍历完一条路径后需要回退
        list.remove(list.size()-1);
        return res;
    }

    /**
     * 回溯
     * @param root
     * @param target
     * @return
     */
    public static ArrayList<ArrayList<Integer>>FindPaths(TreeNode root,int target){
        ArrayList<ArrayList<Integer>>res=new ArrayList<>();
        ArrayList<Integer>list=new ArrayList<>();
        if(root==null){
            return res;
        }
        process(root,target,res,list);
        return res;
    }

    public static void process(TreeNode root,int target,ArrayList<ArrayList<Integer>>res,ArrayList<Integer>list){
        if(root==null||target<0){
            return;
        }
        list.add(root.val);
        if(target-root.val==0&&root.left==null&&root.right==null){
            res.add(new ArrayList<>(list));
        }
        if (root.left!=null){
            process(root.left,target-root.val,res,list);
        }
        if (root.right!=null){
            process(root.right,target-root.val,res,list);
        }
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.left=new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);
        int target=7;
        ArrayList<ArrayList<Integer>> res=FindPaths(node,8);
        Iterator<ArrayList<Integer>>iterator=res.iterator();
        while (iterator.hasNext()){
            ArrayList<Integer> list=iterator.next();
            Iterator<Integer>as=list.iterator();
            while (as.hasNext()){
                System.out.print(as.next()+" ");
            }
        }
    }
}
