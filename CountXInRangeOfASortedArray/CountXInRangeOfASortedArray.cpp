/*
https://www.geeksforgeeks.org/problems/count-x-in-range-of-a-sorted-array/1
*/

class Solution {
  public:
    vector<int> countXInRange(vector<int>& arr, vector<vector<int>>& queries) {
        unordered_map<int, vector<int>>mp;
        int sz=arr.size();
        for(int i=0; i<sz; ++i){
            mp[arr[i]].push_back(i);
        }
        vector<int>res;
        for(auto &query: queries){
            int l=query[0], r=query[1], x=query[2];
            auto &indices=mp[x];
            int count=upper_bound(indices.begin(), indices.end(), r)-
                      lower_bound(indices.begin(), indices.end(), l);
            res.push_back(count);
        }
        return res;
    }
};