import java.util.LinkedList;
import java.util.Queue;

import static java.lang.Math.max;

public class LeetCode007_maxDepth {
    public class TreeNode {
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
    //递归法
    public int maxDepth1(TreeNode root) {
        // 空树返回0，同时这也是终止递归的条件
        if(root==null)
            return 0;
/*
        int maxDepth=1+max(maxDepth(root.left),maxDepth(root.right));
*/
        return 1+Math.max(maxDepth1(root.left),maxDepth1(root.right));
    }

    //迭代法 不熟
    //BFS层序遍历模板

    public int maxDepth2(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth=0;
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++){
                TreeNode node=queue.poll();
                if(node.left!=null) queue.offer(node.left);
                if(node.right!=null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;

    }
}
