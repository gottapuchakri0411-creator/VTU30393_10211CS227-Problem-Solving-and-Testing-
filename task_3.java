class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            if (nums[left] % 2 > nums[right] % 2) {
                // Swap if left is odd and right is even
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }

            if (nums[left] % 2 == 0) left++;
            if (nums[right] % 2 == 1) right--;
        }

        return nums;
    }
}

Input
nums =
[3,1,2,4]
Output
[4,2,1,3]
Expected
[2,4,3,1]
