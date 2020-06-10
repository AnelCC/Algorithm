package com.anelcc;

/*
Binary Tree Data Structure
A tree whose elements have at most 2 children is called a binary tree.
Since each element in a binary tree can have only 2 children,
we typically name them the left and right child.

*/
public class BinaryTreeInverted {
    TreeNode root;

    /*
    [4,2,7,1,3,6,9]  ---> [4, 7, 2, 9, 6, 3, 1]

         4                     4
       /   \                 /   \
      2     7     --->      7     2
     / \   / \    --->     / \   / \
    1   3 6   9           9   6 3   1

    */

    public static void main(String[] args) {
	// write your code here

        BinaryTreeInverted tree = new BinaryTreeInverted();
        tree.root = new TreeNode(4);      //                  4
//                                                             /   \
        tree.root.left = new TreeNode(2);   //            2     \
        tree.root.right = new TreeNode(7);  //           /\     7
//                                                         /  \    /\
        tree.root.left.left = new TreeNode(1);//      1    \   / \
        tree.root.left.right = new TreeNode(3);//          3  /  \
        tree.root.right.left = new TreeNode(6);//            6   \
        tree.root.right.right = new TreeNode(9);//               9

        invertTree(tree.root);
        //[4, 7, 2, 9, 6, 3, 1]
        System.out.println("Tree Inverted: "
                +"\n"+tree.root.val                   //                 4
                +", "+tree.root.left.val              //            7
                +", "+tree.root.right.val            //                       2
                +", "+tree.root.left.left.val       //          9
                +", "+tree.root.left.right.val      //              6
                +", "+tree.root.right.left.val      //                    3
                +", "+tree.root.right.right.val);   //                        1

    }

    static TreeNode invertTree(TreeNode root) {
        // Base condition for empty tree
        if (root == null) {
            return root;
        }

        System.out.println("TreeNode root: "+root.val);

        // this going to the tree Node deeper
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        //swap Tree Nodes
        root.right = left;
        root.left = right;

        return root;
    }

    /*
    A Binary Tree node contains following parts.
    Pointer to left child
    Pointer to right child
    */

    //  Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
