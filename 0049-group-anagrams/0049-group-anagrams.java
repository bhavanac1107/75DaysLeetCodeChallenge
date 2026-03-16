class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
         HashMap<String, List<String>> map = new HashMap<>();

        for(String s : strs){

            int[] count = new int[26];

            for(char c : s.toCharArray()){
                count[c - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();

            for(int num : count){
                keyBuilder.append("#").append(num);
            }

            String key = keyBuilder.toString();

            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());

    }
}