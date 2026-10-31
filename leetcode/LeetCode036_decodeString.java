import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode036_decodeString {
    //双栈迭代版
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                // 多位数累积
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // 存档，进入新层
                countStack.push(num);
                strStack.push(curr);
                curr = new StringBuilder();
                num = 0;
            } else if (c == ']') {
                // 读档，展开当前层
                int repeat = countStack.pop();
                StringBuilder prev = strStack.pop();
                for (int i = 0; i < repeat; i++) {
                    prev.append(curr);
                }
                curr = prev;
            } else {
                // 普通字母
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
