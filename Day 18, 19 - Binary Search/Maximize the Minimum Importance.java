class Solution {
    public static int maxMinImportance(int n, int r, int k, int[] arr) {
        long left = 0, right = k;
        for (int x : arr) right += x;
        long[] v = new long[n];
        while (left <= right) {
            long x = (left + right) / 2;
            for (int i = 0; i < n; ++i) v[i] = arr[i];
            long s = 0, use = 0;
            for (int i = 0; i < r; ++i) s += v[i];
            for (int i = 0; i < n; ++i) {
                // add to t if needed
                int t = Math.min(n - 1, i + r);
                // update sd
                if (i + r < n) s += v[i + r];
                if (i - r > 0) s -= v[i - r - 1];
                long diff = Math.max(0, x - s);
                v[t] += diff;
                s += diff;
                use += diff;
            }
            if (use <= k)
                left = x + 1;
            else
                right = x - 1;
        }
        return (int)right;
    }
}
