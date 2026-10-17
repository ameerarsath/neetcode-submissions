class Solution {
    public int[] topKFrequent(int[] nums, int k) {
         Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create buckets where index = frequency score
        // Max possible frequency is nums.length, so array size needs to be nums.length + 1
        List<Integer>[] buckets = new List[nums.length + 1];
        
        for (int num : countMap.keySet()) {
            int frequency = countMap.get(num);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }

        // Step 3: Iterate backward from highest frequency bucket to lowest
        int[] result = new int[k];
        int index = 0;
        
        for (int i = buckets.length - 1; i >= 0 && index < k; i--) {
            if (buckets[i] != null) {
                for (int num : buckets[i]) {
                    result[index++] = num;
                    if (index == k) {
                        return result;
                    }
                }
            }
        }
        
        return result;
    }
}
