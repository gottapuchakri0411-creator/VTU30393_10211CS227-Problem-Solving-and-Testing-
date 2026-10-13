import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        // Convert the integers to strings for custom sorting
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort strings such that if (a + b) > (b + a), 'a' comes before 'b'
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Handle the edge case where the largest number is 0 (e.g., [0, 0])
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Concatenate all sorted strings to form the final result
        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            sb.append(s);
        }

        return sb.toString();
    }
}



Input
nums =
[10,2]
Output
"210"
