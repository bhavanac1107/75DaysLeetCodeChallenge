class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicates
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // 🔥 Pruning 1: smallest possible sum > 0 → break
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) break;

            // 🔥 Pruning 2: largest possible sum < 0 → skip
            if (nums[i] + nums[n - 2] + nums[n - 1] < 0) continue;

            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates (tight loops)
                    int leftVal = nums[left];
                    int rightVal = nums[right];

                    while (left < right && nums[left] == leftVal) left++;
                    while (left < right && nums[right] == rightVal) right--;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}