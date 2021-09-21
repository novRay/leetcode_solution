// Counting length method
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // set sentinel to handle edge cases when head is to delete
        ListNode sentinel = new ListNode(-1, head);
        int length = getLength(head);
        ListNode p = sentinel;
        for (int i = 0; i < length - n; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        return sentinel.next;
    }
    private int getLength(ListNode head) {
        int size = 0;
        while (head != null) {
            head = head.next;
            size++;
        }
        return size;
    }
}
