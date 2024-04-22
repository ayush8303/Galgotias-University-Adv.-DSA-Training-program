class Solution {
    public boolean isBST(Node root, int min, int max) {
        if (root == null)
            return true;

        // Return false if this node violates the min/max constraint
        if (root.data <= min || root.data >= max) {
            return false;
        }

        // Recursive calls for left and right subtrees
        return isBST(root.left, min, root.data) && isBST(root.right, root.data, max);
    }

    // Overloaded method with default parameters for convenience
    public boolean isBST(Node root) {
        // Call the main method with default minimum and maximum values
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}