class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {
        
        // If target becomes 0, we found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        
        // If target becomes negative, stop this path
        if (target < 0) {
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            
            // Choose
            current.add(candidates[i]);
            
            // Recur (same i because we can reuse element)
            backtrack(candidates, target - candidates[i], i, current, result);
            
            // Backtrack (remove last added element)
            current.remove(current.size() - 1);
        }
    }
}