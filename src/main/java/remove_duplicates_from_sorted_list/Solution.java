package remove_duplicates_from_sorted_list;

/**
 * <a href="http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/">Problem URL</a>
 *
 * @author Jerry Lee
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (head == null) return null;

        ListNode itr = head;
        while (itr.next != null) {
            if (itr.next.val == itr.val) {
                itr.next = itr.next.next;
            } else {
                itr = itr.next;
            }
        }
        return head;
    }
}
