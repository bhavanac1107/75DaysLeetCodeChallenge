class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                // Minimum is in right part
                low = mid + 1;
            } else {
                // Minimum is in left part (including mid)
                high = mid;
            }
        }

        return nums[low];
    }
}