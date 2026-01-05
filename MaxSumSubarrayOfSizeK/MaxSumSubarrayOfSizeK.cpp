/*
https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
*/

class Solution {
  public:
    int maxSubarraySum(vector<int>& arr, int k) {
        int sz=arr.size(), res=INT_MIN, left=0, right=0;
        int cursm=0;
        while(right<=sz-1){
            cursm+=arr[right];
            if(right-left+1>k){
                cursm-=arr[left];
                left++;
            }
            if(right-left+1==k){
                res=max(res, cursm);
            }
            right++;
        }
        return res;
    }
};