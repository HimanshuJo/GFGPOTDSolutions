/*
https://www.geeksforgeeks.org/problems/largest-number-in-one-swap1520/1
*/

class CustomComparator{
    public:
    bool operator()(const pair<char, int>&A, const pair<char, int>&B){
        if((A.first-'0')==(B.first-'0')) return A.second>B.second;
        return A.first>B.first;
    }
};

class Solution {
  public:
    string largestSwap(string &s) {
        string res=s;
        int sz=s.size();
        vector<pair<char, int>>all;
        for(int i=0; i<sz; ++i){
            all.push_back({s[i], i});
        }
        sort(all.begin(), all.end(), CustomComparator());
        int idx1=0, idx2=0;
        set<int>seen;
        while(true){
            if(idx1>=sz||idx2>=all.size()) break;
            while(true){
                auto itr=seen.find(all[idx2].second);
                if(itr!=seen.end()){
                    idx2++;
                } else break;
            }
            if(s[idx1]==all[idx2].first){
                if(idx1==all[idx2].second){
                    seen.insert(idx1);
                    idx1++, idx2++;
                } else{
                    seen.insert(idx1);
                    idx1++;
                }
            } else{
                swap(s[idx1], s[all[idx2].second]);
                res=s;
                break;
            }
        }
        return res;
    }
};