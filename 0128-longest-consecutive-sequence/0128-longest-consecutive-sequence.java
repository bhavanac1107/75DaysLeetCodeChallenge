import java.util.HashSet;

class Solution {

    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Step 1: Put all elements into set
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        // Step 2: Check only sequence starts
        for (int num : set) {

            // Only start if previous number doesn't exist
            if (!set.contains(num - 1)) {

                int currentNum = num;
                int currentLength = 1;

                // Expand sequence
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}