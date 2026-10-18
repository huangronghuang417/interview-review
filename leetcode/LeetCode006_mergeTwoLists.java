public class LeetCode006_mergeTwoLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 我的边界条件太啰嗦了
/*        if(list1==null && list2==null) return list1;
        if(list1!=null && list2 ==null) return list1;
        if(list1==null && list2 != null) return list2;*/

        //边界条件
        if (list1 == null) return list2;
        if (list2 == null) return list1;


        ListNode dummy=new ListNode(0);//虚拟头节点;
        ListNode cur=dummy;

        while(list1!=null && list2 != null){
            if(list1.val<=list2.val){
                cur.next=list1;
                list1=list1.next;
            } else{
                cur.next=list2;
                list2=list2.next;
            }
            //重点
            cur=cur.next;
        }
        if(list1!=null) cur.next=list1;
        if(list2!=null) cur.next=list2;
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


}
