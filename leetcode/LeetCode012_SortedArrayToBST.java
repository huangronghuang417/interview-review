public class LeetCode012_SortedArrayToBST {
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
    public class SortedArrayToBST {

        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return build(nums, 0, nums.length - 1);
        }

        private TreeNode build(int[] nums, int left, int right) {
            // 递归终止：区间无效
            if (left > right) {
                return null;
            }

            // 取中间元素（防溢出写法）
            int mid = left + (right - left) / 2;

            // 创建根节点
            TreeNode root = new TreeNode(nums[mid]);

            // 递归构建左右子树
            root.left = build(nums, left, mid - 1);
            root.right = build(nums, mid + 1, right);

            return root;
        }
    }
}
