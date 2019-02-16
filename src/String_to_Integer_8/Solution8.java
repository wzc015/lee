package String_to_Integer_8;

public class Solution8 {
    private static final int R = 10;
    private static final int MAX = Integer.MAX_VALUE;
    private static final int MIN = Integer.MIN_VALUE;
    private static final int MAX_BOUND = MAX / R;
    private static final int MIN_BOUND = -(MIN / R);
    private static final int MAX_LAST_DIGIT_BOUND = MAX % 10; // including
    private static final int MIN_LAST_DIGIT_BOUND = -(MIN % 10); // including

    public int myAtoi(String str) {
        if (str.equals("")) return 0;

        char[] handle = str.toCharArray();//先转化为char数组
        int result = 0;
        boolean begin = false;//标记是否已经开始记录数字
        StringBuffer title = new StringBuffer();

        for (int i = 0; i < handle.length; i++) {
            if (handle[i] == ' ') {
                if (begin == true) {
                    break;
                }
                continue;
            }
            if (!Character.isDigit(handle[i])) {
                if ((handle[i] == '-' || handle[i] == '+') && begin == false) {
                    begin = true;
                    title.append(handle[i]);
                    continue;
                }
                break;
            } else {
                if (begin == false) {
                    begin = true;
                }
                title.append(handle[i]);
            }
        }
        if (title.toString().equals("") || title.toString().equals("-") || title.toString().equals("+")) {
            return 0;
        }
        try {
            result = Integer.valueOf(title.toString());
        } catch (Exception e) {
            if (title.toString().contains("-")) {
                return Integer.MIN_VALUE;
            } else {
                return Integer.MAX_VALUE;
            }

        }

        return result;
    }

    public int myAtoi2(String str) {
        final int N = str.length();
        int i = 0;
        int abs = 0;
        boolean positive = true;

        // 1. skip whitespaces
        while (i < N && str.charAt(i) == ' ') {
            i++;
        }

        // 2. sign
        if (i < N) {
            final char c = str.charAt(i);
            if (c == '-') {
                positive = false;
                i++;
            } else if (c == '+') {
                i++;
            }
        }

        // 3. digits
        while (i < N) {
            final char c = str.charAt(i);
            if (c > '9' || c < '0') {
                break;
            }

            final int d = c - '0';

            if (positive) {
                if (abs < MAX_BOUND || (abs == MAX_BOUND && d <= MAX_LAST_DIGIT_BOUND)) {
                    abs *= R;
                    abs += d;
                } else {
                    return MAX;
                }
            } else {
                if (abs < MIN_BOUND || (abs == MIN_BOUND && d <= MIN_LAST_DIGIT_BOUND)) {
                    abs *= R;
                    abs += d;
                } else {
                    return MIN;
                }
            }

            i++;
        }

        return positive ? abs : -abs;
    }
}
