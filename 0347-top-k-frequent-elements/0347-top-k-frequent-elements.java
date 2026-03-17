class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         // Step 1: Frequency map
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Convert to list
        List<int[]> list = new ArrayList<>();
        for (int key : map.keySet()) {
            list.add(new int[]{key, map.get(key)});
        }

        // Step 3: Quickselect
        quickSelect(list, 0, list.size() - 1, k);

        // Step 4: Collect result
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }
        return res;
    }

    private void quickSelect(List<int[]> list, int left, int right, int k) {
        if (left >= right) return;

        int pivotIndex = partition(list, left, right);

        if (pivotIndex == k) return;
        else if (pivotIndex < k)
            quickSelect(list, pivotIndex + 1, right, k);
        else
            quickSelect(list, left, pivotIndex - 1, k);
    }

    private int partition(List<int[]> list, int left, int right) {
        int[] pivot = list.get(right);
        int i = left;

        for (int j = left; j < right; j++) {
            if (list.get(j)[1] > pivot[1]) { // higher freq first
                Collections.swap(list, i, j);
                i++;
            }
        }
        Collections.swap(list, i, right);
        return i;
    
    }
}