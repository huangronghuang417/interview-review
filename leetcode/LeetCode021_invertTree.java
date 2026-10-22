public class LeetCode021_invertTree {
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // 交换左右孩子
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 递归处理子树
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    //迭代
    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 交换
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return root;
    }
}
