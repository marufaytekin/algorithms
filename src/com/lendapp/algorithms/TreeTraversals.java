package com.lendapp.algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by maruf on 9/24/16.
 */
public class TreeTraversals<E extends Comparable> {

    public void preOrderTraverse(TreeNode<E> node) {
        if (node != null) {
            node.visit();
            preOrderTraverse(node.getLeft());
            preOrderTraverse(node.getRight());
        }
    }

    public void postOrderTraverse(TreeNode<E> node) {
        if (node != null) {
            postOrderTraverse(node.getLeft());
            postOrderTraverse(node.getRight());
            node.visit();
        }
    }

    public void inOrderTraverse(TreeNode<E> node) {
        if (node != null) {
            inOrderTraverse(node.getLeft());
            node.visit();
            inOrderTraverse(node.getRight());
        }
    }

    public void breadthFirstTraverse(TreeNode<E> node) {
        Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
        q.add(node);
        while (!q.isEmpty()) {
            TreeNode<E> n = q.remove();
            if (n != null) {
                q.add(n.getLeft());
                q.add(n.getRight());
                n.visit();
            }
        }
    }

}
