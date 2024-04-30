#include <bits/stdc++.h>
using namespace std;

#define N 1000000 + 1

void prime_sieve(vector<int> &sieve)
{

  // mark 1 and 0 as non-prime
  sieve[0] = sieve[1] = 0;
  ;

  for (long long p = 2; p < N; p++)
  {
    if (sieve[p] == 1)
    {
      for (long long j = p * p; j < N; j += p)
      {
        // marking j as non-prime
        sieve[j] = 0;
      }
    }
  }
}

int main()
{
  int n;
  cin >> n;
  vector<int> sieve(N, 1);
  prime_sieve(sieve);
  int ans = 0;
  for (int i = 3; i <= n - 2; i++)
  {
    if (sieve[i] == 1 && sieve[i + 2] == 1)
    {
      ans++;
    }
  }
  cout << ans;
  return 0;
}
