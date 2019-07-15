package com.test.llh.Tree;

import sun.reflect.generics.tree.Tree;

/**
 * 打印二叉树的边界结点：
 *
 */
public class PrintEdge {
    /**
     * 边界定义：
     * 1.头结点为边界结点
     * 2.每一层最左及最右结点
     * 3.叶子节点
     *
     * 根据定义：
     * 1.从上到下打印每层最左边的结点
     * 2.先序打印叶子结点（既不是最左又不是最左的结点）
     * 3.从下往上打印最有节点
     * 先用数组记录每一层最左及最右结点
     * @param node
     */
    public static void printEdge(TreeNode node){
        if (node==null){
            return;
        }
        int height=getHeight(node,0);
        TreeNode[][]edgeMap=new TreeNode[height][2];
        setEdgeMap(node,0,edgeMap);
        //打印左边界
        for (int i=0;i<edgeMap.length;i++){
            System.out.print(edgeMap[i][0].val+" ");
        }
        //先序打印叶子节点
        printLeafNotInMap(node,0,edgeMap);
        //打印右边界
        for(int i=edgeMap.length-1;i!=-1;i--){
            if (edgeMap[i][0]!=edgeMap[i][1]){
                System.out.print(edgeMap[i][1].val+" ");
            }
        }
    }
    public static void setEdgeMap(TreeNode node,int level,TreeNode[][]nodeMap){
        if (node==null){
            return;
        }
        nodeMap[level][0]=nodeMap[level][0]==null?node:nodeMap[level][0];
        nodeMap[level][1]=node;
        setEdgeMap(node.left,level+1,nodeMap);
        setEdgeMap(node.right,level+1,nodeMap);
    }
    public static void printLeafNotInMap(TreeNode node,int level,TreeNode[][]nodeMap){
        if (node==null){
            return;
        }
        //是叶子结点并且不是最左和最右结点
        if (node.left==null&&node.right==null&&node!=nodeMap[level][0]&&node!=nodeMap[level][1]){
            System.out.print(node.val+" ");
        }
        printLeafNotInMap(node.left,level+1,nodeMap);
        printLeafNotInMap(node.right,level+1,nodeMap);
    }
    public static int getHeight(TreeNode node,int level){
        if (node==null){
            return level;
        }
        return Math.max(getHeight(node.left,level+1),getHeight(node.right,level+1));
    }

    /**
     * 边界定义：
     * 1.头结点为边界结点
     * 2.叶子结点为边界结点
     * 3.树左边界延伸下去的路径为边界结点
     * 4.树右边界延伸下去的路径为边界结点
     *
     * 由定义知：
     * 1.从头结点往下找，直到找到第一个既有左孩子又有右孩子的结点，在寻找过程中经过的结点都打印
     * 2.找到此节点后，左子树先打印左边界的延伸路径及左子树上的叶子结点
     * 3.右子树打印右边界延伸路径及右子树上的叶子结点
     * @param node
     */
    public static void printEdge2(TreeNode node){
        if (node==null){
            return;
        }
        //先打印头结点
        System.out.print(node.val+" ");
        if (node.left!=null&&node.right!=null){
            //打印左边界结点
            printLeftEdge(node.left,true);
            //打印右边界结点
            printRightEdge(node.right,true);
        }else{
            //继续寻找此节点
            printEdge2(node.left!=null?node.left:node.right);
        }
        System.out.println();
    }
    public static void printLeftEdge(TreeNode node,boolean print){
        if (node==null){
            return;
        }
        if (print||(node.left==null&&node.right==null)){
            System.out.print(node.val+" ");
        }
        printLeftEdge(node.left,print);
        printLeftEdge(node.right,print&&node.left==null?true:false);
    }
    public static void printRightEdge(TreeNode node,boolean print){
        if (node==null){
            return;
        }
        printRightEdge(node.left,print&&node.right==null?true:false);
        printRightEdge(node.right,true);
        if (print||(node.left==null&&node.right==null)){
            System.out.print(node.val+" ");
        }
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(2);
        node.right=new TreeNode(3);
        node.left.right=new TreeNode(4);
        node.right.left=new TreeNode(5);
        node.right.right=new TreeNode(6);
        node.left.right.left=new TreeNode(7);
        node.left.right.right=new TreeNode(8);
        node.right.left.left=new TreeNode(9);
        node.right.left.right=new TreeNode(10);
        node.left.right.right.right=new TreeNode(11);
        node.right.left.left.left=new TreeNode(12);
        node.left.right.right.right.left=new TreeNode(13);
        node.left.right.right.right.right=new TreeNode(14);
        node.right.left.left.left.left=new TreeNode(15);
        node.right.left.left.left.right=new TreeNode(16);
        printEdge(node);
        System.out.println();
        printEdge2(node);
    }
}
