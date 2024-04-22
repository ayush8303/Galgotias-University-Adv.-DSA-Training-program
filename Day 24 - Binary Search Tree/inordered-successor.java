class Solution
{
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x) {
          // Case 1: If right subtree exists
        if (x.right != null) {
            x = x.right;
            while (x.left != null) {
                x = x.left;
            }
            return x;
        }

        Node succ = null;
        while (root != null) {
            if (root.data > x.data) {
                succ = root;
                root = root.left;
            } else if (root.data < x.data) {
                root = root.right;
            } else {
                break;
            }
        }
        return succ;
    }
}