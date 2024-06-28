#include <bits/stdc++.h>
using namespace std;
#define int long long
const int N = 1e5 + 5;
int n, cows;
int positions[N];

bool canPlaceCows(int minDist)
{
  int last_pos = -1;
  int cows_ct = cows;
  for (int i = 0; i < n; i++)
  {
    if (positions[i] - last_pos >= minDist || last_pos == -1)
    {
      cows_ct--;
      last_pos = positions[i];
    }
    if (cows_ct == 0)
      break;
  }
  return cows_ct == 0;
}

int32_t main()
{
  int t;
  cin >> t;
  while (t--)
  {
    cin >> n >> cows;
    for (int i = 0; i < n; i++)
      cin >> positions[i];
    sort(positions, positions + n);
    int lo = 0, hi = 1e9;
    int ans;
    while (lo <= hi)
    {
      int mid = (lo + hi) / 2;
      if (canPlaceCows(mid))
        ans = mid, lo = mid + 1;
      else
        hi = mid - 1;
    }
    cout << ans << endl;
  }
  return 0;
}
