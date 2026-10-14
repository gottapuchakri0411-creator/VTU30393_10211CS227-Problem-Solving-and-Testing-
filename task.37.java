class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int maxCur = 0, maxSum = nums[0];
        int minCur = 0, minSum = nums[0];

        for (int num : nums) {
            totalSum += num;
            
            // Standard Kadane's for maximum subarray sum
            maxCur = Math.max(num, maxCur + num);
            maxSum = Math.max(maxSum, maxCur);
            
            // Kadane's variant for minimum subarray sum
            minCur = Math.min(num, minCur + num);
            minSum = Math.min(minSum, minCur);
        }

        // If all numbers are negative, maxSum will be the largest negative number (the single max element)
        if (maxSum < 0) {
            return maxSum;
        }

        // The maximum circular sum is either the standard max subarray sum
        // or the total sum minus the minimum subarray sum (which represents wrapping around).
        return Math.max(maxSum, totalSum - minSum);
    }
}


Input
nums =
[1,-2,3,-2]
Output
3
Expected
3
