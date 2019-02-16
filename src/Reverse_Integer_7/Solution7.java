package Reverse_Integer_7;

public class Solution7 {
    public int reverse(int x) {

        String handle = String.valueOf(x);
        String symbol = "";
        if (handle.contains("-")) {
            symbol = "-";
        }
        handle = handle.replace("-", "");
        String[] nums = handle.split("");
        for (int start = 0, end = nums.length - 1; start < end; start++, end--) {
            String temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
        }

        StringBuffer str = new StringBuffer();
        str.append(symbol);
        for (String s : nums) {
            str.append(s);
        }
        int answer = 0;
        try {
            answer = Integer.valueOf(str.toString());
        } catch (Exception e) {
            return 0;
        }
        System.out.println(answer);
        return answer;
    }


    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    /*
    java中的“/”、“%”运算，其中前者为取整，后者取余数
    如果超出了范围，其除以10的结果就不会跟之前的结果一致
     */
    public int reverse3(int x) {
        int res = 0;
        while (x != 0) {
            int t = res * 10 + x % 10;
            if (t / 10 != res) {
                System.out.println("wrong");
                return 0;
            }
            res = t;
            x /= 10;
        }
        return res;
    }


}
