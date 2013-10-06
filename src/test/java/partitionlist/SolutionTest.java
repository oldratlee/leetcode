package partitionlist;

import org.junit.Test;

import static org.junit.Assert.assertNull;

/**
 * @author ding.lid
 */
public class SolutionTest {
    @Test
    public void test_partitionlist() throws Exception {
        assertNull(Solution.partition0(null, 0));

        assertListNodeEquals(makeNodeList(1), Solution.partition0(makeNodeList(1), 0));
        assertListNodeEquals(makeNodeList(-1), Solution.partition0(makeNodeList(-1), 0));

        assertListNodeEquals(makeNodeList(1, 1), Solution.partition0(makeNodeList(1, 1), 0));
        assertListNodeEquals(makeNodeList(-1, -1), Solution.partition0(makeNodeList(-1, -1), 0));

        assertListNodeEquals(makeNodeList(-1, 2), Solution.partition0(makeNodeList(2, -1), 0));

        assertListNodeEquals(makeNodeList(1, 2, 2, 4, 3, 5), Solution.partition0(makeNodeList(1, 4, 3, 2, 5, 2), 3));
    }

    static ListNode makeNodeList(int... list) {
        ListNode head = null;
        ListNode tail = null;
        for (int i : list) {
            if (head == null) {
                head = new ListNode(i);
                tail = head;
            } else {
                ListNode node = new ListNode(i);
                tail.next = node;
                tail = node;
            }
        }
        return head;
    }

    static void assertListNodeEquals(ListNode expected, ListNode actual) {
        if (null == expected || null == actual) {
            if (expected != null || expected != actual) {
                throw new AssertionError();
            }
        }

        for (; expected != null && actual != null;
             expected = expected.next, actual = actual.next) {
            if (expected.val != actual.val) {
                throw new AssertionError();
            }
        }
        if (expected != null || actual != null) {
            throw new AssertionError();
        }
    }
}
