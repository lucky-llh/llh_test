package com.test.llh.Tree;

import java.util.HashMap;

/**
 * 在二叉树中找到累加和为指定值的最长路径长度
 */
public class GetMaxLengthInTreeTrace {
    /**
     * 用map记录遍历到结点i时的累加和，key就表示累加和，value表示当前层，只记录累加和第一次出现的位置
     * @param node
     * @param sum
     * @return
     */
    public static int getMaxLength(TreeNode node,int sum){
        HashMap<Integer,Integer>map=new HashMap<>();
        map.put(0,0);
        return preOrder(node,sum,0,1,0,map);
    }
    public static int preOrder(TreeNode node,int sum,int preSum,int level,int maxLen,HashMap<Integer,Integer>map){
        if (node==null){
            return maxLen;
        }
        int curSum=preSum+node.val;
        //如果map中不包含当前累加和，就将其放入map中
        if (!map.containsKey(curSum)){
            map.put(curSum,level);
        }
        if (map.containsKey(sum-curSum)){
            maxLen=Math.max(maxLen,level-map.get(sum-curSum));
        }
        maxLen=preOrder(node.left,sum,preSum,level+1,maxLen,map);
        maxLen=preOrder(node.right,sum,preSum,level+1,maxLen,map);
        if (level==map.get(curSum)){
            map.remove(curSum);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        TreeNode node=new TreeNode(-3);
        node.left=new TreeNode(3);
        node.right=new TreeNode(-9);
        node.left.left=new TreeNode(1);
        node.left.right=new TreeNode(0);
        node.left.right.left=new TreeNode(1);
        node.left.right.right=new TreeNode(6);
        node.right.left=new TreeNode(2);
        node.right.right=new TreeNode(1);
        int length=getMaxLength(node,6);
        System.out.println(length);
    }
}
