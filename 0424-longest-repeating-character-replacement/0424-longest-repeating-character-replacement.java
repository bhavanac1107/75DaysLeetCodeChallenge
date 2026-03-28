class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0, maxFreq = 0, maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // update max frequency
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // if invalid window, shrink
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // update answer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}