/*
https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
*/

class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int lengthOfArr=arr.length, resultantMaxSum=Integer.MIN_VALUE, left=0, right=0;
        int currentSum=0;
        while(right<=lengthOfArr-1){
            currentSum+=arr[right];
            if(right-left+1>k){
                currentSum-=arr[left];
                left++;
            }
            if(right-left+1==k){
                resultantMaxSum=Math.max(resultantMaxSum, currentSum);
            }
            right++;
        }
        return resultantMaxSum;
    }
}