package candy;

/**
 * <a href="http://oj.leetcode.com/problems/candy/">Problem URL</a>
 * <a href="http://blog.csdn.net/u012334315/article/details/12384611">Eul_82</a>
 *
 * @author Eul_82
 */
public class Solution_Eul_82 {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return calcCandyCount(ratings);
    }

    public static int calcCandyCount(int[] ratings) {
        int count = 0;//糖果总数

        int pre = 0;//波峰的前一个糖果数
        int cur = 1;//下一个糖果数
        int v = 0;//波峰是波谷的后一个糖果数时，标记v=2，否则v=0
        final int len = ratings.length;
        for (int i = 0; i < len; i++) {
            count += cur;

            if (i + 1 < len && ratings[i] == ratings[i + 1]) {//权重相等
                pre = 0;
                cur = 1;
                v = 0;
                continue;
            }

            if (i + 2 < len && ratings[i] < ratings[i + 1] && ratings[i + 1] > ratings[i + 2]) { //波峰 
                pre = cur;
                if (v == 2) {//当前权重是波峰，且前一个权重是波谷
                    pre = 1;
                    v = 0;
                }
                cur = 0;
            }
            if (v == 2) {//当前权重非波峰，且前一个权重是波谷
                cur = 1;
                v = 0;
            }
            if (i + 2 < len && (ratings[i] > ratings[i + 1] && ratings[i + 1] <= ratings[i + 2])
                    || (i + 1 == len - 1 && ratings[i] > ratings[i + 1])) { //波谷或数尾
                cur = pre >= cur ? pre : cur;
                v = 2;
            }
            cur++;
        }
        return count;
    }
}
