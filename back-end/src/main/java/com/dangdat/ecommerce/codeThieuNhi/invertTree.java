package com.dangdat.ecommerce.codeThieuNhi;

import java.util.Optional;

class TreeNode {
      int val;
      TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
       this.left = left;
        this.right = right;
   }
  }

public class invertTree {
    public static TreeNode invertTree(TreeNode root) {
        if(root == null) return root;

        TreeNode right = root.right;
        TreeNode left = root.left;

        if(right != null && left != null) {
            root.left = right;
            root.right = left;
        }

        invertTree(left);
        invertTree(right);
        return root;
    }

    public static void main(String[] args) {
        TreeNode right = new TreeNode(2);
        TreeNode root = new TreeNode(1, null, right);

        System.out.println("Root: " + invertTree(root));
    }
}
