import java.util.ArrayList;
import java.util.List;

public class LeetCode020_pathSumII {
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int remain, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        // 叶子节点
        if (node.left == null && node.right == null) {
            if (node.val == remain) {
                result.add(new ArrayList<>(path)); // 必须拷贝
            }
        } else {
            dfs(node.left, remain - node.val, path, result);
            dfs(node.right, remain - node.val, path, result);
        }

        // 回溯
        path.remove(path.size() - 1);
    }
}
