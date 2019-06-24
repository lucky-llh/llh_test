package com.test.llh.Tree;


/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class HasSubtree {
    public boolean hasSubTree(TreeNode node1,TreeNode node2){
        if(node1==null||node2==null){
            return false;
        }
        return hasSubTree(node1.left,node2)|| hasSubTree(node1.right,node2)||checkTree(node1,node2);
    }
    public boolean checkTree(TreeNode node1, TreeNode node2){
        //1.node2遍历完毕都匹配返回true;
        if(node2==null){
            return true;
        }
        //2.node1遍历完，node2还未遍历完毕返回false
        if(node1==null){
            return false;
        }
        //3.当node1和node2根节点相同时，从根节点开始去对比其他节点
        if (node1.val==node2.val){
            return checkTree(node1.left,node2.left)&&checkTree(node1.right,node2.right);
        }
        //4.否则，返回false
        return false;
    }
}
