#include <bits/stdc++.h>
using namespace std;
#define int long long int
#define endl "\n"

void solve()
{
  int n, m;
  cin >> n >> m;
  if (n > m)
  {
    cout << 0 << "\n";
    return;
  }
  int a[n] = {0};
  for (int i = 0; i < n; i++)
    cin >> a[i];
  int ans = 1;
  for (int i = 0; i < n; i++)
  {
    for (int j = i + 1; j < n; j++)
    {
      int temp = abs(a[i] - a[j]) % m;
      ans = ans % m;
      ans = (ans * temp) % m;
    }
  }
  cout << ans << "\n";
  return;
}

int32_t main()
{
  int t = 1;
  // cin>>t;
  while (t--)
    solve();

  return 0;
}
