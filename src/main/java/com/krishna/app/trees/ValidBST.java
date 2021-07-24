package com.krishna.app.trees;

public class ValidBST {

    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode root, Integer low, Integer high) {
        if (root == null) {
            return true;
        }
        if((low != null && root.value <= low) || (high != null && root.value >= high)) {
            return false;
        }
        return validate(root.right, root.value, null) && validate(root.left, null, root.value);
    }

    
}
