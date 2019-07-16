package com.test.llh.Tree;

/**
 * 在二叉树中找到一个节点的后继结点
 * 后继结点：在中序遍历中，是其下一个节点。
 *1.如果该节点有右子树，找到右子树上最左的结点就是其后继结点
 * 2.如果没有右子树，就往上找，直到找到一个结点是其父节点的左孩子，则父结点就是其后继结点
 */
public class GetPostNode {
    public Node getNextNode(Node node){
        if(node==null){
            return null;
        }
        if (node.right!=null){
           return findLeftNodeInRight(node.right);
        }else{
            Node parent=node.parent;
            if (parent!=null&&parent.left!=node){
                node=parent;
                parent=node.parent;
            }
           return parent;
        }
    }
    public Node findLeftNodeInRight(Node node){
        if (node==null){
            return node;
        }
        while (node.left!=null){
            node=node.left;
        }
        return node;
    }
}
