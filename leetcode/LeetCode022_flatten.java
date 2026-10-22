public class LeetCode022_flatten {
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
    //Moris
    public void flatten(TreeNode root) {
        TreeNode cur = root;

        while (cur != null) {
            if (cur.left != null) {
                // 1. 找左子树最右节点
                TreeNode rightmost = cur.left;
                while (rightmost.right != null) {
                    rightmost = rightmost.right;
                }

                // 2. 原右子树接到最右节点后面
                rightmost.right = cur.right;

                // 3. 左子树整体移到右边
                cur.right = cur.left;
                cur.left = null;
            }
            // 4. 继续往右走
            cur = cur.right;
        }
    }
    //先序遍历 + 栈
    public void flatten2(TreeNode root) {
        if (root == null) return;

        java.util.Stack<TreeNode> stack = new java.util.Stack<>();
        stack.push(root);
        TreeNode prev = null;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if (prev != null) {
                prev.left = null;
                prev.right = node;
            }

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);

            prev = node;
        }

        // 最后一个节点 left 置空
        if (prev != null) prev.left = null;
    }
}
