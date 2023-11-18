package zuochengyun_algorithm_study.class03;

public class Code02_DeleteGivenValue2 {
    static class ListNode{
        public  Integer value;
        public ListNode next;
    }
    public static ListNode deleteNode(ListNode head, int val){
        while (head != null) {
            if (head.value != val) {
                break;
            }
            head.next = head;
        }

        ListNode cur = head;
        ListNode pre = head;
        while (cur != null ){
            if (cur.value == val) {
                pre.next = cur.next;
            }else {
                 pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
