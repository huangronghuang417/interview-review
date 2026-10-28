public class LeetCode033_reverseList {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    //迭代
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next; // 暂存下一个节点
            curr.next = prev;         // 反转指针
            prev = curr;              // prev 前移
            curr = next;              // curr 前移
        }

        return prev; // 新的头节点
    }
    //递归
    public ListNode reverseList2(ListNode head) {
        // 空链表 或 只剩一个节点
        if (head == null || head.next == null) {
            return head;
        }

        // 递归反转后面部分
        ListNode newHead = reverseList(head.next);

        // 反转当前节点
        head.next.next = head;
        head.next = null;

        return newHead;
    }
}
