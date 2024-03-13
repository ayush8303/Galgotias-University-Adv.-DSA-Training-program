#include <bits/stdc++.h>
using namespace std;

int maximumScoreOptimised(int a, int b, int c)
{
  int largest = max({a, b, c}), total = a + b + c, sumOfOtherTwo = total - largest;
  return largest >= sumOfOtherTwo ? sumOfOtherTwo : total / 2;
}

int maximumScore(int a, int b, int c)
{
  int ans = 0;
  priority_queue<int> q;
  q.push(a);
  q.push(b);
  q.push(c);
  while (q.size() > 1)
  {
    int x = q.top();
    q.pop();
    int y = q.top();
    q.pop();
    x--;
    y--;
    if (x)
    {
      q.push(x);
    }
    if (y)
    {
      q.push(y);
    }
    ans++;
  }
  return ans;
}
int main()
{
  return 0;
}