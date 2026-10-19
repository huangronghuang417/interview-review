public class LeetCode011_isBalanced {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }

    // 返回子树高度；任意位置失衡就返回 -1
    private int check(TreeNode node) {
        if (node == null) return 0;

        int left = check(node.left);
        if (left == -1) return -1;   // 左子树已失衡，剪枝

        int right = check(node.right);
        if (right == -1) return -1;  // 右子树已失衡，剪枝

        if (Math.abs(left - right) > 1) return -1; // 当前节点失衡

        return Math.max(left, right) + 1;
    }

}
