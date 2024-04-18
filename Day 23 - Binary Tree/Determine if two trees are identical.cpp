class Solution
{
public:
  bool isIdentical(Node *r1, Node *r2)
  {
    if (r1 == NULL or r2 == NULL)
    {
      return r1 == r2;
    }
    if (r1->data != r2->data)
      return false;

    return isIdentical(r1->left, r2->left) &&
           isIdentical(r1->right, r2->right);
  }
};
