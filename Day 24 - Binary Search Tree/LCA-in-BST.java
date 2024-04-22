class BST
{   
    //Function to find the lowest common ancestor in a BST. 
	Node LCA(Node root, int n1, int n2)
	{
        if (root == null)
            return null;

        // case 2 : root == n1 or root == n2
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // right recursive call
        if (root.data < n1 && root.data < n2) {
            return LCA(root.right, n1, n2);
        }

        // left recursive call
        if (root.data > n1 && root.data > n2) {
            return LCA(root.left, n1, n2);
        }

        // case 1
        return root;
    }
    
}