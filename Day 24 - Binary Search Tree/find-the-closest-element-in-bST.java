class Solution
{
    //Function to find the least absolute difference between any node
    //value of the BST and the given integer.
    static int minDiff(Node  root, int K) 
    { 
         Node temp = root;
        int ans = Integer.MAX_VALUE;
        while (temp != null) {
            int currentDiff = Math.abs(temp.data - K);
            ans = Math.min(ans, currentDiff);
            if (temp.data < K) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        return ans;
    } 
}
