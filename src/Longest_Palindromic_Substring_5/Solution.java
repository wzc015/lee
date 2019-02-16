package Longest_Palindromic_Substring_5;

public class Solution {

    private int start = 0;
    private int maxLen = 0;

    public String longestPalindrome(String s) {

        if (s.length() < 2) {
            return s;
        }

        int n = s.length();
        for (int i = 0; i < n-1; ++i) {
            searchPalindrome(s, i, i);
            searchPalindrome(s, i, i + 1);
        }
        return s.substring(start, start+maxLen);


    }

    public void searchPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            --left;
            ++right;
        }
        if (maxLen < right - left - 1) {
            start = left + 1;
            maxLen = right - left - 1;
        }
    }
    public static void main(String[] args) {

        Solution test=new Solution();
        System.out.println(test.longestPalindrome("abcdbbfcba"));

    }


}
