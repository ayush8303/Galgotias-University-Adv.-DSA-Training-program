class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n], right = new int[n];
        
        // Calculate left limits
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? 0 : st.peek() + 1;
            st.push(i);
        }
        
        st.clear(); // Clear the stack for calculating right limits
        
        // Calculate right limits
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n - 1 : st.peek() - 1;
            st.push(i);
        }
        
        // Calculate maximum area
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, heights[i] * (right[i] - left[i] + 1));
        }
        
        return ans;
    }
}