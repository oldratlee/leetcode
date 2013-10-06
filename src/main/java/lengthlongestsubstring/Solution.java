package lengthlongestsubstring;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        return length(s);
    }

    public static int length(String s) {
        DuplexMap<Character, Integer> duplexMap = new DuplexMap<Character, Integer>();

        int start = 0;
        int len = 0;

        final int length = s.length();
        for (int i = 0; i < length; ++i) {
            final char c = s.charAt(i);

            if (duplexMap.containKey(c)) {
                Integer idx = duplexMap.get(c);
                if (idx == null) {
                    continue;
                }

                if (i - start > len)
                    len = i - start;
                for (int j = start; j < idx; ++j) {
                    duplexMap.removeValue(j);
                }
                duplexMap.put(c, i);
                start = idx + 1;
            } else {
                duplexMap.put(c, i);
            }

            if (i == length - 1) {
                if (length - start > len) {
                    len = length - start;
                }
            }
        }

        return len;
    }

    public static class DuplexMap<K, V> {
        private Map<K, V> map = new HashMap<K, V>();
        private Map<V, K> backMap = new HashMap<V, K>();

        void put(K key, V value) {
            V put = map.put(key, value);
            backMap.remove(put);
            backMap.put(value, key);
        }

        V get(K key) {
            return map.get(key);
        }

        K getKey(V value) {
            return backMap.get(value);
        }

        boolean containKey(K key) {
            return map.containsKey(key);
        }

        void remove(K key) {
            V remove = map.remove(key);
            backMap.remove(remove);
        }

        void removeValue(V value) {
            K remove = backMap.remove(value);
            map.remove(remove);
        }
    }
}
