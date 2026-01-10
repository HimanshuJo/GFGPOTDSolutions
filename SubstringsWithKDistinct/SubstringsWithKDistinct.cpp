/*
https://www.geeksforgeeks.org/problems/count-number-of-substrings4528/1
*/

class Solution {
  public:
  
    int substringsAtMost(string &s, int k){
        int sz=s.size(), res=0;
        int freqMap[26]={0};
        int left=0, distinct=0;
        for(int right=0; right<sz; ++right){
            int idx=s[right]-'a';
            if(freqMap[idx]==0) distinct++;
            freqMap[idx]++;
            while(distinct>k){
                int lidx=s[left]-'a';
                freqMap[lidx]--;
                if(freqMap[lidx]==0){
                    distinct--;
                }
                left++;
            }
            res+=right-left+1;
        }
        return res;
    }
  
    int countSubstr(string& s, int k) {
        return substringsAtMost(s, k)-substringsAtMost(s, k-1);
    }
};