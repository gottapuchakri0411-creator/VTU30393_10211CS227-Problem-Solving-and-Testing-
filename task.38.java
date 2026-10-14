class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int i = 0;
        int n = s.length();

        // Step 1: Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i == n) {
            return 0;
        }

        // Step 2: Check sign
        int sign = 1;
        char firstChar = s.charAt(i);
        if (firstChar == '-') {
            sign = -1;
            i++;
        } else if (firstChar == '+') {
            i++;
        }

        // Step 3: Convert digits and handle overflow
        long result = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }

            result = result * 10 + (c - '0');

            // Step 4: Handle 32-bit signed integer overflow/underflow
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (result * sign);
    }
}


Input
s =
"42"
Output
42
