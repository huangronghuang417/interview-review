import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode039_findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 默认小顶堆

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll(); // 弹掉最小的
            }
        }
        return minHeap.peek();
    }
}
