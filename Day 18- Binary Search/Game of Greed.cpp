#include <bits/stdc++.h>
using namespace std;
#define int long long int

bool divideAmongK(int arr[], int n, int k, int min_partition)
{
  int partitions = 0;
  int current_sum = 0;
  for (int i = 0; i < n; i++)
  {
    if (current_sum + arr[i] >= min_partition)
    {
      partitions++;
      current_sum = 0;
    }
    else
    {
      current_sum += arr[i];
    }
  }
  return partitions >= k;
}

int k_partition(int n, int *arr, int k)
{
  int low = 1, high = 1e8;
  int ans;
  while (low <= high)
  {
    int mid = (low + high) / 2;
    bool isPossible = divideAmongK(arr, n, k, mid);
    if (isPossible)
    {
      low = mid + 1;
      ans = mid;
    }
    else
    {
      high = mid - 1;
    }
  }
  return ans;
}

int32_t main()
{
  int n, k;
  cin >> n >> k;
  int arr[n];
  for (int i = 0; i < n; i++)
  {
    cin >> arr[i];
  }
  cout << k_partition(n, arr, k);
  return 0;
}