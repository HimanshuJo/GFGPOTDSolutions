/*
https://www.geeksforgeeks.org/problems/buy-stock-with-transaction-fee/1
*/

class Solution_TLE {
  public:
  
    int dfs(vector<int>&arr, int k, int sz, int idx, int holding){
        if(idx>=sz) return 0;
        if(holding==0){
            int buy=-arr[idx]+dfs(arr, k, sz, idx+1, 1);
            int skip=dfs(arr, k, sz, idx+1, 0);
            return max(buy, skip);
        } else{
            int sell=arr[idx]-k+dfs(arr, k, sz, idx+1, 0);
            int skip=dfs(arr, k, sz, idx+1, 1);
            return max(sell, skip);
        }
    }
  
    int maxProfit(vector<int>& arr, int k) {
        int sz=arr.size(), idx=0, holding=0;
        return dfs(arr, k, sz, idx, holding);
    }
};

// ----- ##### -----

class Solution_OPT {
  public:
    int maxProfit(vector<int>& arr, int k) {
        int sz=arr.size();
        int cash=0, hold=-arr[0];
        for(int i=0; i<sz; ++i){
            int prevCash=cash;
            cash=max(cash, hold+arr[i]-k);
            hold=max(hold, prevCash-arr[i]);
        }
        return cash;
    }
};