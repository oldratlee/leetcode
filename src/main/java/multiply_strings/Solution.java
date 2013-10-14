package multiply_strings;

import java.math.BigInteger;

/**
 * <a href="http://oj.leetcode.com/problems/multiply-strings/">Problem URL</a>
 * <p/>
 * NOTE: Do NOT forget to add <code>import java.math.BigInteger;</code> at the first line!
 *
 * @author Jerry Lee
 */
public class Solution {
    public String multiply(String num1, String num2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return new BigInteger(num1, 10).multiply(new BigInteger(num2, 10)).toString();
    }
}
