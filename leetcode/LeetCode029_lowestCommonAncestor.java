public class LeetCode029_lowestCommonAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }
    //迭代
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur != null) {
            if (p.val < cur.val && q.val < cur.val) {
                cur = cur.left;          // 都在左子树
            } else if (p.val > cur.val && q.val > cur.val) {
                cur = cur.right;         // 都在右子树
            } else {
                return cur;              // 分叉点 / 自身
            }
        }
        return null; // 题目保证 p、q 一定在树中，这行实际走不到
    }
    //递归
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
}
