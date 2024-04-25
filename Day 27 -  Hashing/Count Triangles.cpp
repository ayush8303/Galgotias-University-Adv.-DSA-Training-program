#include <bits/stdc++.h>
using namespace std;

int count_triangles(vector<pair<int, int>> &points)
{
  int n = points.size();
  unordered_map<int, int> freq_x;
  unordered_map<int, int> freq_y;

  for (auto P : points)
  {
    int x = P.first;
    int y = P.second;

    freq_x[x]++;
    freq_y[y]++;
  }
  int ans = 0;
  for (auto P : points)
  {
    int x = P.first;
    int y = P.second;
    int fx = freq_x[x];
    int fy = freq_y[y];

    ans += (fx - 1) * (fy - 1);
  }
  return ans;
}

int main()
{
  int n;
  cin >> n;
  vector<pair<int, int>> points(n);
  for (int i = 0; i < n; i++)
  {
    int x, y;
    cin >> x >> y;
    points[i] = {x, y};
  }
  cout << count_triangles(points);
  return 0;
}