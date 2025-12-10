/*
https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
*/

class Solution {
  public:
    vector<int> findTwoElement(vector<int>& arr) {
        unordered_map<int, int>mp;
        for(auto &vals: arr){
            mp[vals]++;
        }
        int sz=arr.size();
        pair<int, int>pr;
        pr.first=-1, pr.second=-1;
        for(int i=1; i<=sz; ++i){
            if(mp.find(i)!=mp.end()){
                if(mp[i]>1){
                    pr.first=i;
                }
            } else{
                pr.second=i;
            }
            if(pr.first!=-1&&pr.second!=-1) break;
        }
        vector<int>res;
        res.push_back(pr.first);
        res.push_back(pr.second);
        return res;
    }
};