vector<int> Solution::nextGreater(vector<int> &A)
{
  stack<int> st;
  int n = A.size();
  vector<int> ans(n);
  for (int i = n - 1; i >= 0; i--)
  {
    int curr = A[i];
    while (!st.empty() && st.top() <= curr)
      st.pop();
    if (st.empty())
      ans[i] = -1;
    else
      ans[i] = st.top();
    st.push(curr);
  }
  return ans;
}