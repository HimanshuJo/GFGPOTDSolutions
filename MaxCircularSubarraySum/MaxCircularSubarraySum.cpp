/*
https://www.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1
*/

class Solution {
  public:
    int maxCircularSum(vector<int> &arr) {
        // code here
        int sz=arr.size(), curmax=arr[0], curmin=arr[0], maxKd=arr[0], minKd=arr[0], totalSm=arr[0];
        for(int i=1; i<sz; ++i){
            int vals=arr[i];
            curmax=max(arr[i], curmax+vals);
            curmin=min(arr[i], curmin+vals);
            maxKd=max(maxKd, curmax);
            minKd=min(minKd, curmin);
            totalSm+=vals;
        }
        if(maxKd<0) return maxKd;
        return max(maxKd, totalSm-minKd);
    }
};
