import java.util.HashMap;
import java.util.Map;


public class LeetCode001 {


    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        //int[] ans=new int[2];
        //Arrays.fill(ans,-1);
        int[] ans={-1,-1};
        for(int i=0;i<nums.length;i++){
/*            if(map.containsKey(target-nums[i])){
                ans[0]=i;
                ans[1]=map.get(target-nums[i]);
                Arrays.sort(ans);
                return ans;
            }*/
            int need=target-nums[i];
            if(map.containsKey(need)){
                //map里，能找到的一定比当前下标小
                ans[0]=map.get(need);
                ans[1]=i;
                return ans;
            }
            map.put(nums[i],i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LeetCode001 solution = new LeetCode001();

        int[] nums = {3,2,4};
        int target = 6;
        int[] result = solution.twoSum(nums, target);

        System.out.print("[" + result[0] + ", " + result[1] + "]");
    }
}

//踩坑记录
/*
坑	正确做法
HashMap key/value 放反（下标做key）	值做key才能用值去查
先全放再查 → 自己和自己配对	先查再放，map里只有"之前"的元素
赋值顺序反了（大的放前面）	先放map取的（小的），再放i
找到答案只break内层	直接return，最干净
找不到返回 [0,0] 和真实下标混淆	返回 [-1,-1] 哨兵值
Arrays.sort 多此一举	想清楚顺序直接赋值*/
