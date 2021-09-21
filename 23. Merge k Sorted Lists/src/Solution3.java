import java.util.PriorityQueue;

class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length, (a, b)-> Integer.compare(a.val, b.val));
        for (int i = 0; i < lists.length; i++) {
            ListNode l = lists[i];
            while (l != null) {
                queue.add(l);
                l = l.next;
            }
        }
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (!queue.isEmpty()) {
            cur.next = queue.poll();
            cur = cur.next;
        }
        cur.next = null; // Avoid cycle list
        return head.next;
    }

    public static void main(String[] args) {
        Solution3 s3 = new Solution3();
        ListNode l1 = new ListNode(-1, null);
        ListNode l2 = new ListNode(-1, l1);
        ListNode l3 = new ListNode(-1, l2);
        ListNode l4 = new ListNode(-2, l3);

        ListNode n = new ListNode();
        ListNode[] lists = new ListNode[] {l4, null};
        ListNode res = s3.mergeKLists(lists);

    }
}