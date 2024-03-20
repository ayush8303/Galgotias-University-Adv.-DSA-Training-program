// Back-end complete function Template for C++

class Solution
{
public:
  // Function to find number of subArrays
  // with k exactly equal to k.
  int findSubArraySum(int Arr[], int N, int k)
  {
    // STL map to store number of subArrays
    // starting from index zero having
    // particular value of k.
    unordered_map<int, int> prevk;

    int res = 0;

    // k of elements so far.
    int currk = 0;

    for (int i = 0; i < N; i++)
    {

      // Add current element to k so far.
      currk += Arr[i];

      // If currk is equal to desired k,
      // then a new subArray is found. So
      // increase count of subArrays.
      if (currk == k)
        res++;

      // currk exceeds given k by currk
      //  - k. Find number of subArrays having
      // this k and exclude those subArrays
      // from currk by increasing count by
      // same amount.
      if (prevk.find(currk - k) != prevk.end())
        res += (prevk[currk - k]);

      // Add currk value to count of
      // different values of k.
      prevk[currk]++;
    }
    return res;
  }
};