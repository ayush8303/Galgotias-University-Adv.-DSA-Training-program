// Back-end complete function Template for C++

class Solution
{
public:
  bool isGood(vector<int> &arr, int r, long long minPowerRequired, int additionalarr)
  {
    int n = arr.size();
    // init windowPower to store power of 0th city (minus arr[r])
    long long windowPower = accumulate(arr.begin(), arr.begin() + r, 0LL);
    vector<int> additions(n, 0);
    for (int i = 0; i < n; i++)
    {
      if (i + r < n)
      {
        // now, windowPower stores sum of power arr from [i-r..i+r],
        // it also means it's the power of city `ith`
        windowPower += arr[i + r];
      }
      if (windowPower < minPowerRequired)
      {
        long long needed = minPowerRequired - windowPower;
        if (needed > additionalarr)
        {
          // Not enough additional arr to plant
          return false;
        }
        // Plant the additional arr on the farthest city in the range
        // to cover as many cities as possible
        additions[min(n - 1, i + r)] += needed;
        windowPower = minPowerRequired;
        additionalarr -= needed;
      }
      if (i - r >= 0)
      {
        // out of window range
        windowPower -= arr[i - r] + additions[i - r];
      }
    }
    return true;
  }

  long long maxMinImportance(int n, int r, int k, vector<int> &arr)
  {
    long long left = 0;
    // The answer = `right`, when `r = n`, all value of arr are the same!
    long long right = accumulate(arr.begin(), arr.end(), 0LL) + k;
    long long ans = 0;
    while (left <= right)
    {
      long long mid = (left + right) / 2;
      if (isGood(arr, r, mid, k))
      {
        ans = mid;      // This is the maximum possible minimum power so far
        left = mid + 1; // Search for a larger value in the right side
      }
      else
      {
        right = mid - 1; // Decrease minPowerRequired to need fewer additional power arr
      }
    }
    return ans;
  }
};
