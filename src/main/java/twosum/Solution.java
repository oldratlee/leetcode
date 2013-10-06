package twosum;

/**
 * <a href="http://oj.leetcode.com/problems/two-sum/">Problem URL</a>
 *
 * @author Jerry Lee
 */
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return findSumIndex(numbers, target);
    }

    public static int[] findSumIndex(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; ++i) {
            for (int j = i + 1; j < numbers.length; ++j) {
                if (numbers[i] + numbers[j] == target)
                    return new int[]{i + 1, j + 1};
            }
        }
        return null;
    }
}
