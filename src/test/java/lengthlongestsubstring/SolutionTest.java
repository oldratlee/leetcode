package lengthlongestsubstring;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author ding.lid
 */
public class SolutionTest {
    @Test
    public void test_lengthlongestsubstring() throws Exception {
        assertEquals(0, Solution.length(""));
        assertEquals(1, Solution.length("a"));

        assertEquals(1, Solution.length("aa"));
        assertEquals(2, Solution.length("ab"));

        assertEquals(1, Solution.length("bbb"));
        assertEquals(2, Solution.length("aba"));

        assertEquals(2, Solution.length("ababa"));
        assertEquals(2, Solution.length("ababaa"));

        assertEquals(3, Solution.length("abcbb"));
        assertEquals(3, Solution.length("abcabcbb"));
    }
}
