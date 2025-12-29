/*
https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
*/

class Solution {
  public:
    int kthElement(vector<int> &a, vector<int> &b, int k) {
        multimap<int, int>mp;
        for(auto &vals: a) mp.insert({vals, vals});
        for(auto &vals: b) mp.insert({vals, vals});
        vector<int>tmp;
        for(auto &entry: mp){
            tmp.push_back(entry.first);
        }
        return tmp[k-1];
    }
};