package twosum;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * @author Jerry Lee
 */
public class SolutionTest {
    @Test
    public void test_twoSum() throws Exception {
        assertArrayEquals(new int[]{1, 2}, Solution.findSumIndex(new int[]{2, 7, 11, 15}, 9));
    }
}
