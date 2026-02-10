/*
https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1
*/

class Solution {
  public:
    int maxProduct(vector<int> &arr) {
        int sz=arr.size(), currMax=arr[0], currMin=arr[0], res=arr[0];
        for(int i=1; i<sz; ++i){
            int curr=arr[i], prevMax=currMax;
            currMax=max({curr, curr*currMax, curr*currMin});
            currMin=min({curr, curr*prevMax, curr*currMin});
            res=max({res, currMax, currMin});
        }
        return res;
    }
};