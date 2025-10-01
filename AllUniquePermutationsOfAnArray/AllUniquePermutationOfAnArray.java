/*
https://www.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1
*/

class Solution {
    
    public ArrayList<ArrayList<Integer>> resultantPermutations;
    
    public Solution() {
        resultantPermutations = new ArrayList<>();
    }
    
    public ArrayList<ArrayList<Integer>> getResultantPermutations() {
        return resultantPermutations;
    }
    
    public void depthFirstSearch_forArrays(int[] arr, int lengthOfArr, ArrayList<Integer> currentPermutation, ArrayList<Boolean> seenIndices) {
        if(currentPermutation.size() == lengthOfArr) {
            resultantPermutations.add(new ArrayList<>(currentPermutation));
            return;
        }
        
        for(int i = 0; i < lengthOfArr; ++i) {
            if(seenIndices.get(i)) continue;
            if(i > 0 && arr[i] == arr[i-1] && !seenIndices.get(i-1)) continue;
            
            seenIndices.set(i, true);
            currentPermutation.add(arr[i]);
            depthFirstSearch_forArrays(arr, lengthOfArr, currentPermutation, seenIndices);
            currentPermutation.remove(currentPermutation.size()-1);
            seenIndices.set(i, false);
        }
    }
    
    public void generateAllUniquePermutations(int[] arr) {
        Arrays.sort(arr);
        int lengthOfArr = arr.length;
        ArrayList<Integer> currentPermutation = new ArrayList<>();
        ArrayList<Boolean> seenIndices = new ArrayList<>();
        for(int i = 0; i < lengthOfArr; ++i) {
            seenIndices.add(false);
        }
        depthFirstSearch_forArrays(arr, lengthOfArr, currentPermutation, seenIndices);
    }
    
    public ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        generateAllUniquePermutations(arr);
        return getResultantPermutations();
    }
}
