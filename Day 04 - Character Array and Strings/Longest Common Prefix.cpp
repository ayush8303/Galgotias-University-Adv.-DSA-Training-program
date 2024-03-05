#include <bits/stdc++.h>
using namespace std;


int main()
{
    int n;
    cin >> n;
    string arr[n];
    for (int i = 0; i < n; i++) {
        cin >> arr[i]; // ith string as input
    }
    int ans = -1;
    for (int i = 0; i < arr[0].length(); i++) {
        bool flag = 1;
        for (int j = 0; j < n; j++) {
            if (arr[j].length() <= i) {
                flag = 0;
            }
            else {
                if (arr[j][i] != arr[0][i]) {
                    flag = 0;
                }
            }
        }
        if (flag == 0) break;
        else ans = i;
    }
    for (int i = 0; i <= ans; i++) {
        cout << arr[0][i];
    }
    cout << endl;
    return 0;
}