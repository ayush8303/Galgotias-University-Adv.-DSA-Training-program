class Node {
    int key;
    Node left, right;

    // Parameterized constructor
    Node(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

public class implementation {
    static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        // Recursive case
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    static void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;
        int[] arr = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int x : arr) {
            root = insert(root, x);
        }
        inorder(root);
    }
}
