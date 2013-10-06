
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Jerry Lee
 */
public class CandyTest {
    @Test
    public void test_candy() throws Exception {
        assertEquals(0, Candy.calcCandyCount(new int[]{}));

        assertEquals(1, Candy.calcCandyCount(new int[]{1,}));
        assertEquals(1, Candy.calcCandyCount(new int[]{100,}));

        assertEquals(2, Candy.calcCandyCount(new int[]{1, 1,}));
        assertEquals(3, Candy.calcCandyCount(new int[]{1, 2,}));
        assertEquals(3, Candy.calcCandyCount(new int[]{2, 1,}));

        assertEquals(3, Candy.calcCandyCount(new int[]{1, 1, 1}));
        assertEquals(4, Candy.calcCandyCount(new int[]{1, 1, 2}));
        assertEquals(4, Candy.calcCandyCount(new int[]{2, 1, 1}));
        assertEquals(4, Candy.calcCandyCount(new int[]{2, 2, 1}));
        assertEquals(5, Candy.calcCandyCount(new int[]{2, 1, 2}));
        assertEquals(4, Candy.calcCandyCount(new int[]{1, 2, 1}));

        assertEquals(6, Candy.calcCandyCount(new int[]{1, 2, 3}));
        assertEquals(6, Candy.calcCandyCount(new int[]{3, 2, 1}));

        assertEquals(7, Candy.calcCandyCount(new int[]{1, 2, 3, 3}));

        assertEquals(9, Candy.calcCandyCount(new int[]{1, 2, 3, 3, 1}));
        assertEquals(10, Candy.calcCandyCount(new int[]{1, 2, 3, 3, 3, 1}));
    }
}
