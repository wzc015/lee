package Palindrome_Number_9;

public class Solution9 {
    public boolean isPalindrome(int x) {
        int origin=x;
        if (x < 0) {
            return false;
        }

        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            rev = rev * 10 + pop;
            //System.out.println(rev);
        }
        if (rev == origin) {
            return true;
        } else {
            return false;
        }

    }
}
