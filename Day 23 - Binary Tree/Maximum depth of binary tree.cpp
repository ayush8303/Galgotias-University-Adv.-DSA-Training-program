class Solution
{
public:
  int maxDepth(Node *root)
  {
    if (root == NULL)
      return 0;
    int lh = maxDepth(root->left);
    int rh = maxDepth(root->right);
    return max(lh, rh) + 1;
  }
};