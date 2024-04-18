class Solution
{
public:
  int ans = INT_MIN;
  int solve(TreeNode *node)
  {
    if (!node)
      return 0;
    int l = max(solve(node->left), 0);
    int r = max(solve(node->right), 0);
    int cur = node->val + l + r;
    ans = max(ans, cur);
    return node->val + max(l, r);
  }
  int maxPathSum(TreeNode *root)
  {
    solve(root);
    return ans;
  }
};