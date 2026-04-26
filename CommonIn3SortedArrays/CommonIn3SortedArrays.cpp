/*
https://www.geeksforgeeks.org/problems/common-elements1132/1
*/

class Solution {
  public:
    vector<int> commonElements(vector<int> &a, vector<int> &b, vector<int> &c) {
        map<int, int>mpa, mpb;
        for(auto &vals: a){
            mpa[vals]++;
        }
        for(auto &vals: b){
            mpb[vals]++;
        }
        vector<int>res;
        set<int>unqst;
        for(auto &vals: c){
            unqst.insert(vals);
        }
        for(auto &stval: unqst){
            auto itr1=mpa.find(stval);
            auto itr2=mpb.find(stval);
            if(itr1!=mpa.end()&&itr2!=mpb.end()){
                res.push_back(stval);
            }
        }
        sort(res.begin(), res.end());
        return res;
    }
};