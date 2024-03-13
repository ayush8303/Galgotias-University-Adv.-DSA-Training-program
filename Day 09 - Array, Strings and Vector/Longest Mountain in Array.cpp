#include <bits/stdc++.h>
using namespace std;

int longestMountain(vector<int> A)
{
  int N = A.size(), res = 0;
  vector<int> up(N, 0), down(N, 0);
  for (int i = N - 2; i >= 0; --i)
    if (A[i] > A[i + 1])
      down[i] = down[i + 1] + 1;
  for (int i = 0; i < N; ++i)
  {
    if (i > 0 && A[i] > A[i - 1])
      up[i] = up[i - 1] + 1;
    if (up[i] && down[i])
      res = max(res, up[i] + down[i] + 1);
  }
  return res;
}

int main()
{

  return 0;
}
