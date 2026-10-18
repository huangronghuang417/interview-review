public class LeetCode005_reverseList {

    //迭代
    public ListNode reverseList1(ListNode head) {
        if (head == null) return head;
        ListNode prep = null;
        ListNode curr=head;
        while (head != null) {

            ListNode next=curr.next;
            curr.next=prep;
            prep=curr;
            curr=next;
/*            result = head;
            head = head.next;
            head.next = prep;
            prep = result;*/
        }
        return prep;
    }

    //递归
    public ListNode reverseList2(ListNode head) {
        // 递归终止条件
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {

        int[] head = {1, 2, 3, 4, 5};

        int target = 9;
        int ans = binarySearch(nums, target);


        System.out.print(ans);
    }
}
