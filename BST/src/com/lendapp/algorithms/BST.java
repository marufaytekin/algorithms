package com.lendapp.algorithms;

/**
 * build balanced binary search tree from a sorted array.
 * recursive implementation
 */

class Node {
    Integer val;
    Node left;
    Node right;
}

class BST {
    static Node root;
    public BST() {
    }

    private Node insert(Node n, int val) {
        if (n == null) {
            Node temp = new Node();
            temp.val = val;
            return temp;
        } else if (val < n.val){
            n.left = insert(n.left, val);
        } else if (val > n.val) {
            n.right = insert (n.right, val);
        } else {
            n.val = val;
        }
        return n;
    }

    public void insert(int val) {
        root = insert(root, val);
    }
}

class Main {

    public static void main(String[] args) {
        // write your code here

        int [] sortedArr = {1,2,3,5,7,9,10,13,18};
        int n = sortedArr.length;
        BST bst = new BST();
        insert(bst, sortedArr, 0, n-1);

        System.out.println(bst.root.val);
        printTree(bst.root);
    }

    public static void insert(BST bst, int [] arr, int lo, int hi){
        if (hi < lo) return;
        int mid = lo + (hi - lo) / 2;
        System.out.print(arr[mid] + " ");
        bst.insert(arr[mid]);
        insert(bst, arr, lo, mid-1);
        insert(bst, arr, mid+1, hi);
    }


    private static void printTree(Node n) {
        if (n == null) return;
        System.out.print("(");
        printTree(n.left);
        Integer v = n.val;
        if (v != null) System.out.print(v);
        printTree(n.right);
        System.out.print(")");

    }


}
