class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
    ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> Q = new LinkedList<>();

        // Process only the first k elements
        for (int i = 0; i < k; i++) {
            while (!Q.isEmpty() && arr[i] >= arr[Q.peekLast()]) {
                Q.pollLast();
            }
            Q.offerLast(i);
        }
        ans.add(arr[Q.peekFirst()]);

        // Remaining windows
        for (int i = k; i < n; i++) {
            // Step 1 - Contraction (Remove elements not part of the window)
            while (!Q.isEmpty() && Q.peekFirst() <= i - k) {
                Q.pollFirst();
            }
            // Step 2 - Store elements in strictly decreasing order
            while (!Q.isEmpty() && arr[i] >= arr[Q.peekLast()]) {
                Q.pollLast();
            }
            Q.offerLast(i);

            // Step 3 - Find answer for the current window
            ans.add(arr[Q.peekFirst()]);
        }
        return ans;
    }
}