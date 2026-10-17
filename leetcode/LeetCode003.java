import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode003 {


    public static List<List<Integer>> threeSum(int[] nums) {
        //主动防御
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> result =new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) break;
            //去重重点
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left=i+1;
            int right=nums.length-1;
            int target=-nums[i];
            while(left<right){
                int sum= nums[left]+nums[right];
                if(sum>target){
                    right--;
                } else if(sum<target){
                    left++;
                } else{
                    //重点
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //去重重点
                    while(left<right && nums[left]==nums[left+1]) left++;
                    while(left<right && nums[right]==nums[right-1]) right--;

                    left++;
                    right--;
                }
            }
        }
        return result;
    }



    public static void main(String[] args) {

        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result=threeSum(nums);


        System.out.print(result);
    }
}
