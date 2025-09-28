/*
https://www.geeksforgeeks.org/problems/ascii-range-sum/1
*/

class Solution {
  public:
  
    int ascii(char ch){
        return static_cast<int>(ch);
    }
  
    vector<int> asciirange(string& s) {
        map<char, int>mp1;
        map<char, vector<int>>mp2;
        int sz=s.size();
        for(int i=0; i<sz; ++i){
            auto ch=s[i];
            mp1[ch]++;
            mp2[ch].push_back(i);
        }
        vector<int>res;
        for(auto &entries: mp1){
            if(entries.second>=2){
                auto curvec=mp2[entries.first];
                int firstpos=curvec[0], lastpos=curvec[curvec.size()-1], cursm=0;
                for(int i=firstpos+1; i<lastpos; ++i){
                    cursm+=ascii(s[i]);
                }
                if(cursm==0) continue;
                res.push_back(cursm);
            }
        }
        return res;
    }
};
