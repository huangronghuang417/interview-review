public class LeetCode022_isSymmetric {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
//递归
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return isMirror(root.left, root.right);
        }

        private boolean isMirror(TreeNode p, TreeNode q) {
            if (p == null && q == null) return true;
            if (p == null || q == null) return false;

            return p.val == q.val
                    && isMirror(p.left, q.right)
                    && isMirror(p.right, q.left);
        }
    //迭代
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();

            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;

            // 镜像配对入队
            queue.offer(t1.left);
            queue.offer(t2.right);

            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }
}
