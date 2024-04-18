class GFG
{
	public ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            ArrayList<Integer> cur = new ArrayList<>();
            int sz = q.size();
            while (sz-- > 0) {
                Node n = q.poll();
                cur.add(n.data);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            if (!leftToRight) Collections.reverse(cur);
            ans.addAll(cur);
            leftToRight ^= true;
        }
        return ans;
    }
}