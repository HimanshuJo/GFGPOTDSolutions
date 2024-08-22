/*
https://www.geeksforgeeks.org/problems/split-an-array-into-two-equal-sum-subarrays/1
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canSplit(int arr[]) {
        int lengthOfArr=arr.length;
        ArrayList<Integer>prefixSum=new ArrayList<>();
        ArrayList<Integer>suffixSum=new ArrayList<>();
        prefixSum.add(arr[0]);
        for(int i=1; i<lengthOfArr; ++i){
            prefixSum.add(prefixSum.get(prefixSum.size()-1)+arr[i]);
        }
        suffixSum.add(arr[lengthOfArr-1]);
        for(int i=lengthOfArr-2; i>=0; --i){
            suffixSum.add(suffixSum.get(suffixSum.size()-1)+arr[i]);
        }
        Collections.reverse(suffixSum);
        for(int i=0; i<lengthOfArr-1; ++i){
            int currentPrefixSum=prefixSum.get(i), currentSuffixSum=suffixSum.get(i+1);
            if(currentPrefixSum==currentSuffixSum) return true;
        }
        return false;
    }
}