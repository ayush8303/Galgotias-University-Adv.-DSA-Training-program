public class Solution {
    public int[] nextGreater(int[] A) {
        Stack<Integer> st = new Stack<>();
        int n = A.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int curr = A[i];
            while (!st.isEmpty() && st.peek() <= curr)
                st.pop();
            if (st.isEmpty())
                ans[i] = -1;
            else
                ans[i] = st.peek();
            st.push(curr);
        }
        return ans;
    }
}