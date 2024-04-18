class Solution {
    int ans = Integer.MIN_VALUE;
    
    public int solve(TreeNode node) {
        if (node == null) return 0;
        int l = Math.max(solve(node.left), 0);
        int r = Math.max(solve(node.right), 0);
        int cur = node.val + l + r;
        ans = Math.max(ans, cur);
        return node.val + Math.max(l, r);
    }
    
    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }
}