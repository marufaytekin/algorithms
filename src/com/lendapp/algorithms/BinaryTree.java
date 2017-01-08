package com.lendapp.algorithms;


/**
 * Created by maruf on 9/24/16.
 */
public class BinaryTree <E extends Comparable> {

    TreeNode<E> root;

    public BinaryTree(E elem) {
        this.root = new TreeNode<E>(elem);
    }

    public BinaryTree() {
        this.root = new TreeNode<E>();
    }

    /**
     * Search method with while loop.
     * @param elem
     * @return
     */
    public TreeNode<E> search (E elem) {
        TreeNode<E> temp = root;
        int comp;
        while(temp != null)
        {
            comp = elem.compareTo(temp.getValue());
            if (comp < 0) temp = temp.getLeft();
            else if (comp > 0) temp = temp.getRight();
            else return temp;
        }
        return null;
    }

    /**
     * Recursive search method.
     * @param elem
     * @param t
     * @return
     */
    public TreeNode<E> rSearch(E elem, TreeNode<E> t) {
        if (elem == null || t == null) return null;
        int comp = elem.compareTo(t.getValue());
        if (comp < 0) t = rSearch(elem, t.getLeft());
        else if (comp > 0) t = rSearch(elem, t.getRight());
        return t;
    }


    /**
     * Insert method with while loop
     * @param elem
     * @return
     */
    public boolean insert(E elem) {
        TreeNode<E> temp = root;
        int comp = elem.compareTo(temp.getValue());

        while(comp < 0 && temp.getLeft() != null ||
                comp > 0 && temp.getRight() != null)
        {
            if (comp < 0) temp = temp.getLeft();
            else temp = temp.getRight();
            comp = elem.compareTo(temp.getValue());
        }
        if (comp < 0) temp.addLeftChild(elem);
        else if (comp > 0) temp.addRightChild(elem);
        else return false;
        return true;
    }

    /**
     * Recursive insert method.
     * @param elem
     * @param t
     * @return
     */
    public TreeNode<E> rInsert(E elem, TreeNode<E> t) {
        int comp = elem.compareTo(t.getValue());
        if (comp < 0 && t.getLeft() != null) t.left = rInsert(elem, t.getLeft());
        else if (comp > 0 && t.getRight() != null) t.right = rInsert(elem, t.getRight());
        else if (comp > 0) t.addRightChild(elem);
        else if (comp < 0) t.addLeftChild(elem);
        return t;
    }

    /**
     * Delete method.
     * @param elem
     * @param t
     * @return
     */
    public TreeNode <E> delete (E elem, TreeNode<E> t) {
        if (t == null) return t;
        if (elem.compareTo(t.getValue()) < 0)
            t.left = delete(elem, t.getLeft());
        else if (elem.compareTo(t.getValue()) > 0)
            t.right = delete(elem, t.getRight());
        else if (t.getLeft() != null && t.getRight() != null) {
            t.setValue(findMin(t.getRight()).getValue());
            t.right = delete(elem, t.getRight());
        } else {
            t = (t.getLeft() != null ) ? t.getLeft() : t.getRight();
        }
        return t;
    }

    private TreeNode<E> findMin(TreeNode<E> node) {
        if (node == null) return node;
        else if (node.getLeft() == null) return node;
        else return findMin(node.getLeft());
    }

}

class TreeNode<E extends Comparable> {

    private E value;
    TreeNode <E> par;
    TreeNode <E> left;
    TreeNode <E> right;

    public TreeNode() {
        this.value = null;
        this.par = null;
        this.left = null;
        this.right = null;
    }

    public TreeNode(E value) {
        this.value = value;
        this.par = null;
        this.left = null;
        this.right = null;
    }

    public TreeNode(E value, TreeNode<E> par) {
        this.value = value;
        this.par = par;
        this.left = null;
        this.right = null;
    }

    public void visit(){
        System.out.print(this.value + "->");
    }

    public TreeNode<E> addLeftChild(E value) {
        this.left = new TreeNode<E>(value, this);
        return this.left;
    }

    public TreeNode<E> addRightChild(E value) {
        this.right = new TreeNode<E>(value, this);
        return this.right;
    }

    public TreeNode<E> getPar() {
        return par;
    }

    public TreeNode<E> getLeft() {
        return left;
    }

    public TreeNode<E> getRight() {
        return right;
    }

    public E getValue() {
        return value;
    }

    public E removeLeft() {
        E val = left.getValue();
        this.left = null;
        return val;
    }

    public E removeRight() {
        E val = right.getValue();
        this.right = null;
        return val;
    }

    public void setValue(E value) {
        this.value = value;
    }
}
