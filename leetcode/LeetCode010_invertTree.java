public class LeetCode010_invertTree {
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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // 递归翻转子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 交换左右
        root.left = right;
        root.right = left;

        return root;
    }
//迭代
public TreeNode invertTree2(TreeNode root) {
    if (root == null) return null;

    java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode cur = queue.poll();

        // 交换左右孩子
        TreeNode tmp = cur.left;
        cur.left = cur.right;
        cur.right = tmp;

        if (cur.left != null) queue.offer(cur.left);
        if (cur.right != null) queue.offer(cur.right);
    }
    return root;
}

}
