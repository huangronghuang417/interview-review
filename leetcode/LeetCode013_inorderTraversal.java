import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCode013_inorderTraversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res);
        return res;
    }

    private void dfs(TreeNode node, List<Integer> res) {
        if (node == null) return;

        dfs(node.left, res);   // 左
        res.add(node.val);     // 根
        dfs(node.right, res);  // 右
    }

    //迭代法
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            // 一路向左
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            // 左到底了，弹栈
            curr = stack.pop();
            res.add(curr.val);

            // 处理右子树
            curr = curr.right;
        }
        return res;
    }
}
