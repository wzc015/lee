package Longest_Substring_Without_Repeating_Characters_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;

    }

    public int lengthOfLongestSubstring2(String s) {
        int result = 0;
        int begin = 0;
        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(begin, i - 1);
            int length = i - begin;
            String ch = s.substring(i - 1, i);
            if (!temp.contains(ch)) {
                if (length > result) {
                    result = length;
                }
            } else {
                //begin = i - 1;
                begin = map.get(ch) + 1;
            }
            map.put(ch, i - 1);

        }
        System.out.println(result);
        return result;
    }
}
