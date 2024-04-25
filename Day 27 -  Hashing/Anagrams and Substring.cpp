#include <bits/stdc++.h>
using namespace std;

vector<int> getHashValue(string &s, int i, int j)
{
  vector<int> freq(26, 0);
  for (int k = i; k <= j; k++)
  {
    freq[s[k] - 'a']++;
  }
  return freq;
}

int anagrams_substring(string &s)
{
  int n = s.length();
  map<vector<int>, int> mp;
  for (int i = 0; i < n; i++)
  {
    for (int j = i; j < n; j++)
    {
      // substring s[i....j]
      vector<int> h = getHashValue(s, i, j);
      mp[h]++;
    }
  }
  int ans = 0;
  for (auto p : mp)
  {
    int freq = p.second;
    ans += (freq * (freq - 1)) / 2;
  }
  return ans;
}

int main()
{
  string s;
  cin >> s;

  cout << anagrams_substring(s);
  return 0;
}