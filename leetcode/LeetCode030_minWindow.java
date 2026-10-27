public class LeetCode030_minWindow {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int left = 0, right = 0;
        int matchCount = 0;           // 已满足需求的字符种类数
        int needCount = 0;            // t 中不同字符种类数
        for (int cnt : need) {
            if (cnt > 0) needCount++;
        }

        int minLen = Integer.MAX_VALUE;
        int start = 0;                // 最小窗口起点

        while (right < s.length()) {
            char r = s.charAt(right);
            if (need[r] > 0) {
                need[r]--;
                if (need[r] == 0) matchCount++;   // 该字符凑够了
            }
            right++;

            // 窗口合法，尝试收缩
            while (matchCount == needCount) {
                // 更新答案
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char l = s.charAt(left);
                if (need[l] >= 0) {        // l 是 t 中字符
                    need[l]++;
                    if (need[l] > 0) matchCount--; // 不够了
                }
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
