class Solution
{
public:
  vector<int> nextGreaterElements(vector<int> &nums)
  {
    int n = nums.size();
    stack<int> s;
    vector<int> res(n, -1);

    for (int i = 2 * n - 1; i >= 0; --i)
    {
      int num = nums[i % n];
      while (!s.empty() && s.top() <= num)
        s.pop();
      if (!s.empty() && i < n)
        res[i] = s.top();
      s.push(num);
    }
    return res;
  }
};