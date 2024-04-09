#include <bits/stdc++.h>
using namespace std;
// #define int long long int

int32_t main()
{
    int n, k;
    cin >> n >> k;
    vector<int> arr(n);
    for (int i = 0; i < n; i++)
        cin >> arr[i];
    int l = 1, r = 1e9, mid, ans;
    while (l <= r)
    {
        mid = (l + r) / 2;
        int sum = 0;
        for (int i = 0; i < n; i++)
        {
            sum += (arr[i] - 1) / mid;
        }
        if (sum <= k)
        {
            ans = mid;
            r = mid - 1;
        }
        else
        {
            l = mid + 1;
        }
    }
    cout << ans << endl;
    return 0;
}