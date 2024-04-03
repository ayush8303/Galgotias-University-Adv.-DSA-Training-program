class Solution
{
public:
  vector<int> asteroidCollision(vector<int> &a)
  {
    int n = a.size();
    stack<int> st;
    for (int i = 0; i < n; i++)
    {
      if (a[i] > 0 or st.empty())
      {
        st.push(a[i]);
      }
      else
      {
        while (!st.empty() and st.top() > 0 and st.top() < abs(a[i]))
        {
          st.pop();
        }
        if (st.empty())
        {
          st.push(a[i]);
        }
        else if (st.top() == abs(a[i]))
          st.pop();
        else if (st.top() < 0)
          st.push(a[i]);
      }
    }
    vector<int> ans;
    while (st.size())
    {
      ans.push_back(st.top());
      st.pop();
    }
    reverse(ans.begin(), ans.end());
    return ans;
  }
};