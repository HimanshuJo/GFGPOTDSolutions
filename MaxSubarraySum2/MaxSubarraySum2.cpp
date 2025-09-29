/*
https://www.geeksforgeeks.org/problems/maximum-subarray-sum--110820/1
*/

class Solution {
  public:
    int maxSubarrSum(vector<int>& arr, int a, int b) {
        int sz=arr.size(), res=INT_MIN;
        vector<int>prefixSum(sz+1, 0);
        for(int i=0; i<sz; ++i){
            prefixSum[i+1]=prefixSum[i]+arr[i];
        }
        deque<int>dq;
        for(int i=1; i<=sz; ++i){
            if(i-a>=0){
                int idx=i-a;
                while(!dq.empty()&&prefixSum[dq.back()]>prefixSum[idx]){
                    dq.pop_back();
                }
                dq.push_back(idx);
            }
            while(!dq.empty()&&dq.front()<i-b){
                dq.pop_front();
            }
            if(!dq.empty()){
                res=max(res, prefixSum[i]-prefixSum[dq.front()]);
            }
        }
        return res;
    }
};