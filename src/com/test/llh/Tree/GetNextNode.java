package com.test.llh.Tree;

/**
 * 二叉树的下一个结点：
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class GetNextNode {
    /**
     * 二叉树的后继续结点：二叉树中序遍历顺序下该节点的下一个节点
     * 1.首先看有没有右子树，若有，就查找右子树上最左的结点
     * 2.没有右子树，及去在左子树该节点往上找，知道找到一个结点是其父节点的左孩子，则该父节点就是其后继节点
     * @param node
     * @return
     */
    public TreeLinkNode getNextNode(TreeLinkNode node){
        if (node==null){
            return null;
        }
        if(node.right!=null){
            return findLeftNodeInRightTree(node.right);
        }else{
            TreeLinkNode parent=node.next;
            while (parent!=null&&parent.left!=node){
                node=parent;
                parent=node.next;
            }
            return parent;
        }
    }
    public TreeLinkNode findLeftNodeInRightTree(TreeLinkNode node){
        if (node.left!=null){
            node=node.left;
        }
        return node;
    }
}
