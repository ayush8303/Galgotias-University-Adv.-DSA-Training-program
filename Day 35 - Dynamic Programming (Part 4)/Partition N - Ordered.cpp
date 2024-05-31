#include <bits/stdc++.h>
using namespace std;

int memo[1000]; // fill with -1
// Topdown -> O(n^2)
int orderedSet(int n)
{
  if (n == 0)
    return 1;
  if (memo[n] != -1)
    return memo[n];
  int ans = 0;
  for (int i = 1; i <= n; i++)
  {
    ans += orderedSet(n - i);
  }
  memo[n] = ans;
  return ans;
}

int main()
{
  int n;
  cin >> n;
  memset(memo, -1, sizeof(memo));
  cout << orderedSet(n) << endl;

  // bottom up -> O(n)
  int sum = 0;
  int f[n + 1];
  f[0] = 1;
  sum = f[0];
  for (int i = 1; i <= n; i++)
  {
    f[i] = sum;
    sum += f[i];
  }
  cout << f[n] << endl;
  cout << pow(2, n - 1) << endl; // O(1)

  return 0;
}