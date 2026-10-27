public class LeetCode031_productExceptSelf {
    //左右两个辅助数组
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 1. 第一遍：answer[i] 存 i 左侧所有元素乘积
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 2. 第二遍：从右往左补右侧乘积
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return answer;
    }

    /*    关键顺序 别写反了
answer[i] *= rightProduct;  // 先乘当前右侧积
    rightProduct *= nums[i];    // 再把这个元素纳入右侧积*/


}
