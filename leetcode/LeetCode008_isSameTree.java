import java.util.LinkedList;
import java.util.Queue;

public class LeetCode008_isSameTree {
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

    //递归
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        // 你的代码
        if (p == null && q == null) {
            return true;
        }
/*        if(p==null && q!=null)return false;
        if(p!=null && q==null) return false;*/
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);


    }

    //迭代手法
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null) return false;
            if (node1.val != node2.val) return false;
            queue.offer(node1.left);
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }
        return true;
    }

}
