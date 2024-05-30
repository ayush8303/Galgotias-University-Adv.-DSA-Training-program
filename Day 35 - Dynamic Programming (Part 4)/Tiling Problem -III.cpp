#include <bits/stdc++.h>

using namespace std;

int main()
{

  int n;
  cin >> n;

  int f[n + 1], g[n + 1];
  f[0] = g[0] = 1;
  f[1] = g[1] = 1;
  f[2] = g[2] = 2;

  for (int i = 3; i <= n; i++)
  {
    f[i] = f[i - 1] + f[i - 2] + 2 * g[i - 2];
    g[i] = g[i - 1] + f[i - 1];
  }

  cout << f[n];

  return 0;
}