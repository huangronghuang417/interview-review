import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode032_merge {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        // 1. 按左端点升序排序（用 Integer.compare 防溢出）
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        // 2. 初始化当前区间
        int curStart = intervals[0][0];
        int curEnd = intervals[0][1];

        // 3. 线性扫描
        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0];
            int e = intervals[i][1];

            if (s <= curEnd) {
                // 重叠或相接，扩展右端点
                curEnd = Math.max(curEnd, e);
            } else {
                // 不重叠，收尾当前区间，开新区间
                merged.add(new int[]{curStart, curEnd});
                curStart = s;
                curEnd = e;
            }
        }

        // 4. 最后一个区间入结果
        merged.add(new int[]{curStart, curEnd});

        return merged.toArray(new int[merged.size()][]);
    }
}
