package candy;

/**
 * <a href="http://oj.leetcode.com/problems/candy/">Problem URL</a>
 * <p/>
 * 利用对称性，递增累加。在<a href="http://blog.csdn.net/u012334315/article/details/12384611">Eul_82</a>的基础上调整。
 *
 * @author Jerry Lee
 * @see Solution_Eul_82
 */
public class Solution {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return calcCandyCount(ratings);
    }

    public static int calcCandyCount(int[] ratings) {
        final int len = ratings.length;

        int count = 0; //糖果总数
        int cur = 1;
        int preTop = Integer.MAX_VALUE; // 设置int_max，之后波谷就不需要校正，因为下坡长度不会大于int_max

        for (int i = 0; i < len; ++i) {
            // 重置cur，调整preTop
            if (i - 1 >= 0 && ratings[i - 1] == ratings[i]) { // 相等直接重置
                cur = 1;
                preTop = Integer.MAX_VALUE;
            } else if (i - 2 >= 0 && ratings[i - 2] < ratings[i - 1] && ratings[i - 1] > ratings[i]) { // 开始下坡
                preTop = cur - 1;
                cur = 1;
            } else if (i - 2 >= 0 && ratings[i - 2] > ratings[i - 1] && ratings[i - 1] < ratings[i]) { // 开始上坡
                cur = 2; // 波谷是1，而波谷后的开始上坡的值是2
            }

            // 波谷 或 下坡到尾部 时，进行校正
            if (i - 1 >= 0 && i + 1 < len && ratings[i - 1] > ratings[i] && ratings[i] <= ratings[i + 1]
                    || i - 1 >= 0 && i == len - 1 && ratings[i - 1] > ratings[i]) {
                int delta = cur + 1 - preTop; // 下坡长度 大于 上坡长度 的量，即是要校正的量
                if (delta > 0) {
                    cur += delta;
                }
            }

            count += cur;
            cur++;
        }
        return count;
    }
}
