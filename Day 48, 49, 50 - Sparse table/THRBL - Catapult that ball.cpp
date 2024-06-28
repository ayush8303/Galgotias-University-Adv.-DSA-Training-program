#include <bits/stdc++.h>
using namespace std;

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

int main()
{

  int n, m;
  cin >> n >> m;
  vector<int> a(n);
  for (int i = 0; i < n; i++)
    cin >> a[i];
  table.build(a);
  int cnt = 0;
  for (int i = 0; i < m; i++)
  {
    int l, r;
    cin >> l >> r;
    l--, r--;
    if (table.queryMaximum(l, r - 1) == a[l])
      cnt++;
  }
  cout << cnt << endl;
  return 0;
}