import java.util.List;

public class LeetCode004 {

    public static int binarySearch(int[] nums, int target) {
        // 你的代码
        if(nums==null || nums.length==0) return -1;
        /*int ans=-1;*/
/*        空数组处理不够好
        if(nums==null) return ans;*/
        int left=0;
        int right=nums.length-1;
        /*int mid;*/
        while(left<=right){
            /*mid=left+(right-left)/2;*/
            int mid=left+(right-left)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else if(nums[mid]>target){
                right=mid-1;
            } else {
/*                ans=mid;
                break;*/
                return mid;
            }
        }
        /*return ans;*/
        return -1;

    }

    public static void main(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target=9;
        int ans=binarySearch(nums,target);


        System.out.print(ans);
    }
}
