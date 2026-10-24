import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode025_averageOfLevels {
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
    //BFS
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            long sum = 0; // 用 long 防溢出

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(sum * 1.0 / size);
        }
        return res;
    }

    //DFS 不是重点
    private List<Long> sum = new ArrayList<>();
    private List<Integer> count = new ArrayList<>();

    public List<Double> averageOfLevels2(TreeNode root) {
        dfs(root, 0);
        List<Double> res = new ArrayList<>();
        for (int i = 0; i < sum.size(); i++) {
            res.add(sum.get(i) * 1.0 / count.get(i));
        }
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        if (depth == sum.size()) {
            sum.add(0L);
            count.add(0);
        }
        sum.set(depth, sum.get(depth) + node.val);
        count.set(depth, count.get(depth) + 1);

        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }

}
