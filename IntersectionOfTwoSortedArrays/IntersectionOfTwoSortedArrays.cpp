/*
https://www.geeksforgeeks.org/problems/intersection-of-two-sorted-arrays-with-duplicate-elements/1
*/

class Solution {
  public:
    vector<int> intersection(vector<int>& a, vector<int>& b) {
        map<int, int>mp1, mp2;
        for(auto &vals: a){
            mp1[vals]++;
        }
        for(auto &vals: b){
            mp2[vals]++;
        }
        vector<int>res;
        for(auto &entries: mp1){
            auto itr=mp2.find(entries.first);
            if(itr!=mp2.end()) res.push_back(entries.first);
        }
        return res;
    }
};