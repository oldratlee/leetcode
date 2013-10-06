package add_two_numbers;

/**
 * <a href="http://oj.leetcode.com/problems/add-two-numbers/">Problem URL</a>
 *
 * @author Jerry Lee
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ListNode head = null;
        ListNode tail = null;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            ListNode node = new ListNode(carry);
            if (l1 != null) {
                node.val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                node.val += l2.val;
                l2 = l2.next;
            }
            carry = node.val / 10;
            node.val = node.val % 10;

            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = node;
            }
        }
        
        return head;
    }
}
