package com.company;

import com.company.tree.Solution;
import com.company.tree.TreeNode;

public class Main {

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        Solution solution = new Solution();
        solution.inorderTraversal(root);
    }
}
