public class LeetCode015_diameterOfBinaryTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }
    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    // 返回以 node 为根的子树高度（叶子高度为 1）
    private int height(TreeNode node) {
        if (node == null) return 0;

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        // 经过当前节点的最长路径（边数）
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // 返回当前子树高度
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
