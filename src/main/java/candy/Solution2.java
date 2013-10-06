package candy;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="http://oj.leetcode.com/problems/candy/">Problem URL</a>
 *
 * @author Jerry Lee
 */
public class Solution2 {
    public int candy(int[] ratings) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return calcCandyCount(ratings);
    }

    private static class UndulationInfo {
        public UndulationInfo(int adjust, int upLen, int downLen) {
            this.adjust = adjust;
            this.upLen = upLen;
            this.downLen = downLen;
        }

        public int adjust;
        public int upLen;
        public int downLen;
    }

    public static int calcCandyCount(int[] weights) {
        final int length = weights.length;

        int adjust = 0;
        List<UndulationInfo> infoList = new ArrayList<UndulationInfo>();
        for (int i = 0; i < length; ) {
            int upLen = 0;
            int downLen = 0;
            while (i + 1 < length && weights[i + 1] > weights[i]) {
                ++upLen;
                ++i;
            }
            while (i + 1 < length && weights[i + 1] < weights[i]) {
                ++downLen;
                ++i;
            }
            infoList.add(new UndulationInfo(adjust, upLen, downLen));

            if (i == length - 1) break;
            if (i + 1 < length && weights[i + 1] == weights[i]) {
                adjust = 0; // 如果相等，新起一个没有起点重合的山坡
                ++i;
            } else {
                adjust = -1; // 如果不相等（实际上是重新上坡），新起一个起点重合的山坡。校正值为-1
            }
        }

        return calcFromUndulationInfo(infoList);
    }

    private static int calcFromUndulationInfo(List<UndulationInfo> infoList) {
        int count = 0;
        for (UndulationInfo info : infoList) {
            count += info.adjust // 校正值
                    + info.upLen * (info.upLen + 1) / 2 // 上升坡的和
                    + info.downLen * (info.downLen + 1) / 2 // 下降坡的和
                    + Math.max(info.upLen, info.downLen) + 1; // 坡顶的值
        }
        return count;
    }
}
