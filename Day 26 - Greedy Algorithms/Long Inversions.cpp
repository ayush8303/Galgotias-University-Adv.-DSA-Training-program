#include <bits/stdc++.h>
using namespace std;

void solve()
{
  int n;
  string s;
  cin >> n >> s;
  for (int k = n; k > 0; k--)
  {
    vector<int> t(n), end(n + 1);
    for (int i = 0; i < n; i++)
    {
      t[i] = s[i] - '0';
    }
    int cnt = 0;
    for (int i = 0; i < n; i++)
    {
      cnt -= end[i];
      t[i] ^= (cnt & 1);
      if (t[i] == 0)
      {
        if (i + k <= n)
        {
          ++end[i + k];
          ++cnt;
          t[i] = 1;
        }
        else
          break;
      }
    }
    if (*min_element(t.begin(), t.end()) == 1)
    {
      cout << k << endl;
      return;
    }
  }
}
int main()
{
  int t = 1;
  cin >> t;
  while (t--)
    solve();

  return 0;
}