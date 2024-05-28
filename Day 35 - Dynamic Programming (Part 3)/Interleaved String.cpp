class Solution
{
public:
  string s1, s2, s3;
  vector<vector<int>> memo;
  int dp(int i, int j)
  {

    int k = i + j;
    if (k == s3.size())
      return true;

    if (memo[i][j] != -1)
      return memo[i][j];

    int ans = 0;
    if (i < s1.size() && s1[i] == s3[k])
    {
      ans |= dp(i + 1, j);
    }

    if (j < s2.size() && s2[j] == s3[k])
    {
      ans |= dp(i, j + 1);
    }

    return memo[i][j] = ans;
  }
  bool isInterleave(string A, string B, string C)
  {
    this->s1 = A;
    this->s2 = B;
    this->s3 = C;
    if (A.size() + B.size() != C.size())
      return false;
    memo.resize(A.size() + 1, vector<int>(B.size() + 1, -1));
    return dp(0, 0);
  }
};