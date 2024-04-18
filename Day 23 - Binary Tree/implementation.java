import java.util.*;

class Node {
    public  int data;
    public Node left, right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class implementation {
    static Scanner scanner = new Scanner(System.in);

    public static Node buildTree() {
        int key = scanner.nextInt();

        if (key == -1) {
            return null;
        }

        Node n = new Node(key);
        n.left = buildTree();
        n.right = buildTree();
        return n;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public  static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                System.out.print(cur.data + " ");

                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Node root = buildTree();
        // inorder(root);
        // preorder(root);
        // postorder(root);
        levelOrder(root);
    }
}
