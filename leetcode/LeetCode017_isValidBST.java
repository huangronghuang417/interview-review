public class LeetCode017_isValidBST {
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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, long min, long max) {
        if (node == null) return true;

        // 当前节点必须在 (min, max) 内
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // 左子树上限变成 node.val，右子树下限变成 node.val
        boolean leftValid = dfs(node.left, min, node.val);
        boolean rightValid = dfs(node.right, node.val, max);

        return leftValid && rightValid;
    }
}
