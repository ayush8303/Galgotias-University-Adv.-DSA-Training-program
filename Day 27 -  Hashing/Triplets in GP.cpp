#include <bits/stdc++.h>
using namespace std;

int count_triplets(vector<int> &arr, int r)
{
  int n = arr.size();
  map<int, int> left, right;
  for (int x : arr)
  {
    right[x]++;
  }
  int ans = 0;
  for (int j = 0; j < n; j++)
  {
    right[arr[j]]--;

    if (arr[j] % r == 0)
    {
      int a = arr[j] / r;
      int b = arr[j];
      int c = arr[j] * r;
      ans += left[a] * right[c];
    }
    left[arr[j]]++;
  }
  return ans;
}

int main()
{
  int n, r;
  cin >> n >> r;
  vector<int> arr(n);
  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }

  cout << count_triplets(arr, r);

  return 0;
}