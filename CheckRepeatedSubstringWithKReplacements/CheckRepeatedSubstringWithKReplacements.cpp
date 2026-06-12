/*
https://www.geeksforgeeks.org/problems/check-if-a-string-is-repetition-of-its-substring-of-k-length3302/1
*/

class Solution {
  public:
    bool kSubstr(string &s, int k) {
        map<string, pair<int, vector<int>>>mp;
        int sz=s.size(), idx=0;
        if(sz%k!=0) return false;
        while(idx<=sz-1){
            int curcount=0, bgnIdx=idx;
            string curr="";
            while(true){
                curr+=s[idx++];
                curcount++;
                if(curcount==k) break;
            }
            auto &itr=mp[curr];
            itr.first++;
            itr.second.push_back(bgnIdx);
        }
        if(mp.size()==1) return true;
        if(mp.size()>2) return false;
        for(auto &entries: mp){
            if(entries.second.first==1){
                for(auto &vals: entries.second.second){
                    if(vals%k==0) return true;
                }
            }
        }
        return false;
    }
};