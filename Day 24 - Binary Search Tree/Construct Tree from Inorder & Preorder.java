class Solution
{
    // Function to find the index of a target element in an array starting from a given index
    public static int findIndex(int arr[], int start, int target)
    {
        // Initialize iterator "i" to 0
        int i=0;
        // Iterate through the array until the target element is found at the given start index
        while( arr[start+i] != target ) i++;
        // Return the index "i" where the target element is found
        return i;
    }

    // Recursive function to build a binary tree using inorder and preorder traversal arrays
    public static Node buildUtil(int inorder[], int preorder[], int inStart, int preStart, int n)
    {
        // Base case: if n (number of elements) is 0, return null
        if(n==0) 
            return null;
        
        // Create a new node with the value at preStart index of preorder array
        Node ret = new Node( preorder[preStart] );
        
        // Find the index "i" of the root value in the inorder array
        int i = findIndex( inorder, inStart, preorder[preStart] );
        
        // Recursively build the left subtree using elements before the root in inorder and preorder arrays
        ret.left = buildUtil( inorder, preorder, inStart, preStart+1, i );
        // Recursively build the right subtree using elements after the root in inorder and preorder arrays
        ret.right = buildUtil( inorder, preorder, inStart+i+1, preStart+i+1, n-i-1 );
        
        // Return the constructed binary tree
        return ret;
    }
    
    // Function to build a binary tree using inorder and preorder traversal arrays
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        // Call the recursive function to build the tree
        return buildUtil(inorder, preorder, 0, 0, n);
    }
}