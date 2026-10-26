public class LeetCode027_isValidBST {
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
    class Solution {
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean dfs(TreeNode node, long min, long max) {
            if (node == null) return true;

            // 当前节点必须严格在 (min, max) 内
            if (node.val <= min || node.val >= max) {
                return false;
            }

            boolean leftOk = dfs(node.left, min, node.val);
            boolean rightOk = dfs(node.right, node.val, max);

            return leftOk && rightOk;
        }
    }
}
