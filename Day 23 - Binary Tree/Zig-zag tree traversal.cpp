class Solution
{
public:
  // Function to store the zig zag order traversal of tree in a list.
  vector<int> zigZagTraversal(Node *root)
  {
    vector<int> ans;
    queue<Node *> q;
    q.push(root);
    bool leftToRight = 1;
    while (!q.empty())
    {
      vector<int> cur;
      int sz = q.size();
      while (sz--)
      {
        Node *n = q.front();
        q.pop();
        cur.push_back(n->data);
        if (n->left != NULL)
          q.push(n->left);
        if (n->right != NULL)
          q.push(n->right);
      }
      if (leftToRight == 0)
        reverse(cur.begin(), cur.end());
      for (int x : cur)
      {
        ans.push_back(x);
      }
      leftToRight ^= 1;
    }
    return ans;
  }
};