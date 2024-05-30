#include <bits/stdc++.h>
using namespace std;

int memo[1000][1000]; // fill with -1
// TC -> O(n^3)
int unorderedSet(int min, int n)
{
  if (n == 0)
    return 1;
  if (memo[min][n] != -1)
    return memo[min][n];
  int ans = 0;
  for (int i = min; i <= n; i++)
  {
    ans += unorderedSet(i, n - i);
  }
  memo[min][n] = ans;
  return ans;
}

// TC -> O(n^2)
int unorderedSet2(int min, int n)
{
  if (n == 0)
    return 1;
  if (min > n)
    return 0;
  if (memo[min][n] != -1)
    return memo[min][n];
  int ans = unorderedSet2(min + 1, n) // exclude
            +
            unorderedSet2(min, n - min); // include
  memo[min][n] = ans;
  return ans;
}

int main()
{
  int n;
  cin >> n;
  memset(memo, -1, sizeof(memo));
  for (int i = 0; i <= n; i++)
  {
    cout << unorderedSet(1, i) << ' ';
  }
  cout << endl;

  memset(memo, -1, sizeof(memo));
  for (int i = 0; i <= n; i++)
  {
    cout << unorderedSet2(1, i) << ' ';
  }

  return 0;
}