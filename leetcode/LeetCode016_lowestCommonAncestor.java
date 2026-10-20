public class LeetCode016_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 空节点
        // 2. 当前节点就是 p 或 q
        if (root == null || root == p || root == q) {
            return root;
        }

        // 后序：先左后右
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 左右都找到 → 当前节点是 LCA
        if (left != null && right != null) {
            return root;
        }

        // 否则返回非空的那个
        return left != null ? left : right;
    }
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
}
