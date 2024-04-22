class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
    int index;

    public void preorder(TreeNode root, int[] ans) {
        if (root == null)
            return;
        ans[index++] = root.data;
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    public TreeNode buildTree(int start, int end, int[] arr) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = buildTree(start, mid - 1, arr);
        root.right = buildTree(mid + 1, end, arr);
        return root;
    }

    public int[] sortedArrayToBST(int[] nums) {
        TreeNode root = buildTree(0, nums.length - 1, nums);
        int[] ans = new int[nums.length];
        index = 0;
        preorder(root, ans);
        return ans;
    }
}
