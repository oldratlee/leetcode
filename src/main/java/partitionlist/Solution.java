package partitionlist;

/**
 * <a href="http://oj.leetcode.com/problems/partition-list/">Problem URL</a>
 * <p/>
 * <code>
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }</code>
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return partition0(head, x);
    }

    public static ListNode partition0(ListNode head, int x) {
        if (null == head) return null;

        List smallList = new List();
        List bigList = new List();

        for (; head != null; head = head.next) {
            if (head.val < x) {
                smallList.add(head.val);
            } else {
                bigList.add(head.val);
            }
        }
        smallList.join(bigList);

        return smallList.head;
    }

    public static class List {
        ListNode head;
        ListNode tail;

        public List() {
            head = null;
            tail = null;
        }

        void add(int x) {
            ListNode node = new ListNode(x);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        void join(List list) {
            if (list == null) return;
            if (head == null) {
                head = list.head;
                tail = list.tail;
            } else {
                tail.next = list.head;
                tail = list.head;
            }
        }
    }
}
