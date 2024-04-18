class Pair {
    public int inc;
    public int exc;
}

class Solution {
    public Pair recur(Node root) {
        Pair p = new Pair();
        if (root == null) {
            p.inc = 0;
            p.exc = 0;
            return p;
        }
        Pair left = recur(root.left);
        Pair right = recur(root.right);

        // include root
        p.inc = root.data + left.exc + right.exc;

        // exclude root
        p.exc = Math.max(left.inc, left.exc) + Math.max(right.inc, right.exc);
        return p;
    }

    public int getMaxSum(Node root) {
        Pair ans = recur(root);
        return Math.max(ans.inc, ans.exc);
    }
}