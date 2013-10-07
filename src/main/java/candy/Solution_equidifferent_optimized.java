package candy;

/**
 * <a href="http://oj.leetcode.com/problems/candy/">Problem URL</a>
 *
 * @author Jerry Lee
 */
public class Solution_equidifferent_optimized {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return calcCandyCount(ratings);
    }

    public static int calcCandyCount(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;

        final int length = ratings.length;
        int count = 0;
        int adjust = 0;
        int idx = 0;
        while (true) {
            int upLen = 0;
            int downLen = 0;
            while (idx + 1 < length && ratings[idx + 1] > ratings[idx]) {
                ++upLen;
                ++idx;
            }
            while (idx + 1 < length && ratings[idx + 1] < ratings[idx]) {
                ++downLen;
                ++idx;
            }
            count += calcUndulationSum(adjust, upLen, downLen);

            if (idx == length - 1) break;
            if (idx + 1 < length && ratings[idx + 1] == ratings[idx]) {
                adjust = 0; // 如果相等，新起一个没有起点重合的山坡
                ++idx;
            } else {
                adjust = -1; // 如果不相等（实际上是重新上坡），新起一个起点重合的山坡。校正值为-1
            }
        }

        return count;
    }

    private static int calcUndulationSum(int adjust, int upLen, int downLen) {
        return adjust // 校正值
                + upLen * (upLen + 1) / 2 // 上升坡的和
                + downLen * (downLen + 1) / 2 // 下降坡的和
                + Math.max(upLen, downLen) + 1; // 坡顶的值
    }
}
