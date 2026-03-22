class Solution {
    public int[] twoSum(int[] numbers, int target) {
         int left = 0;                   // start pointer
        int right = numbers.length - 1; // end pointer

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Return 1-indexed positions
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++;   // increase sum
            } else {
                right--;  // decrease sum
            }
        }

        // Since the problem guarantees exactly one solution, this line is never reached
        return new int[]{-1, -1};
    }
}