/*
https://www.geeksforgeeks.org/problems/all-unique-permutations-of-an-array/1
*/

class Solution {
  public:
  
    void dfs(vector<int>&arr, const int sz, vector<vector<int>>&res, vector<int>curr, vector<bool>&seen){
        if(curr.size()==sz){
            res.push_back(curr);
            return;
        }
        for(int i=0; i<sz; ++i){
            if(seen[i]) continue;
            if(i>0&&arr[i]==arr[i-1]&&!seen[i-1]) continue;
            seen[i]=true;
            curr.push_back(arr[i]);
            dfs(arr, sz, res, curr, seen);
            curr.pop_back();
            seen[i]=false;
        }
        return;
    }
  
    vector<vector<int>> genAllUniquePermus(vector<int>&arr){
        sort(arr.begin(), arr.end());
        int sz=arr.size();
        vector<vector<int>>res;
        vector<int>curr;
        vector<bool>seen(sz, false);
        dfs(arr, sz, res, curr, seen);
        return res;
    }
  
    vector<vector<int>> uniquePerms(vector<int>& arr) {
        return genAllUniquePermus(arr);
    }
};