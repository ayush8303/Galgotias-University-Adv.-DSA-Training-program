#include <bits/stdc++.h>
using namespace std;
#define int int64_t

class sparseTable
{
public:
  int MAX_N = 100005;
  const int LOG = 17; // 18 if MAX_N=200005
  int a[100005];
  int minimum[100005][17]; // minimum[i][j] is minimum among a[i..i+(2^j)-1]
  int maximum[100005][17]; // maximum[i][j] is maximum among a[i..i+(2^j)-1]
  int bin_log[100005];

  void build(vector<int> &arr)
  {
    int n = arr.size();
    for (int i = 0; i < n; i++)
    {
      minimum[i][0] = arr[i];
      maximum[i][0] = arr[i];
    }
    bin_log[1] = 0;
    for (int i = 2; i <= n; i++)
    {
      bin_log[i] = bin_log[i / 2] + 1;
    }
    for (int k = 1; k < LOG; k++)
    {
      for (int i = 0; i + (1 << k) - 1 < n; i++)
      {
        minimum[i][k] = min(minimum[i][k - 1], minimum[i + (1 << (k - 1))][k - 1]);
        maximum[i][k] = max(maximum[i][k - 1], maximum[i + (1 << (k - 1))][k - 1]);
        // for range minimum query
      }
    }
  }
  int queryMinimum(int L, int R)
  { // O(1)
    int length = R - L + 1;
    int k = bin_log[length];
    return min(minimum[L][k], minimum[R - (1 << k) + 1][k]);
  }
  int queryMaximum(int L, int R)
  { // O(1)
    int length = R - L + 1;
    int k = bin_log[length];
    return max(maximum[L][k], maximum[R - (1 << k) + 1][k]);
  }
} table;
int findRightMostIndex(int L, int k, vector<int> &a)
{
  int n = a.size();
  int low = L, high = n - 1;
  int ans = L;
  while (low <= high)
  {
    int mid = (low + high) / 2;
    if (abs(table.queryMaximum(L, mid) - table.queryMinimum(L, mid)) <= k)
    {
      ans = mid;
      low = mid + 1;
    }
    else
      high = mid - 1;
  }
  return ans;
}

int32_t main()
{
  int n, k;
  cin >> n >> k;
  vector<int> a(n);
  for (int i = 0; i < n; i++)
    cin >> a[i];
  table.build(a);
  int ans = 0;
  for (int L = 0; L < n; L++)
  {
    int maxR = findRightMostIndex(L, k, a);
    ans += (maxR - L + 1);
  }
  cout << ans << endl;

  return 0;
}
