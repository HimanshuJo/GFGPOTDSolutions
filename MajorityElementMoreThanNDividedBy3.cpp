/*
https://www.geeksforgeeks.org/problems/majority-vote/1
*/

class Solution {
  public:
    vector<int> findMajority(vector<int>& arr) {
        int sz=arr.size();
        map<int, int>mp;
        for(auto &vals: arr) mp[vals]++;
        vector<int>res;
        for(auto &entries: mp){
            if(entries.second>floor(sz/3)){
                res.push_back(entries.first);
            }
        }
        return res;
    }
};
