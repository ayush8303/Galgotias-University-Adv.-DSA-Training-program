class Solution
{
    public int[] calculateSpan(int[] price, int n) {
        Stack<Integer> st = new Stack<>();
        int[] span = new int[n];
        
        for (int i = 0; i < n; i++) {
            int current_price = price[i];
            
            // step1 -> remove indices with strictly smaller order of their values
            while (!st.isEmpty() && price[st.peek()] <= current_price) {
                st.pop();
            }
            // step2 - find span value
            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }
            
            // step3 - add current index
            st.push(i);
        }
        return span;
    }   
}