/*
https://www.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1
*/

class Solution_TLE {
  public:
  
    void dfs(string &str, const int sz, int currentIdx, set<string>&allSubs, string currentString){
        if(currentIdx==sz){
            allSubs.insert(currentString);
            return;
        }
        dfs(str, sz, currentIdx+1, allSubs, currentString);
        dfs(str, sz, currentIdx+1, allSubs, str[currentIdx]+currentString);
        return;
    }
  
    int distinctSubseq(string &str) {
        int sz=str.size(), idx=0;
        set<string>allSubs;
        string curr="";
        dfs(str, sz, idx, allSubs, curr);
        return allSubs.size();
    }
};

// ------- ******* -------

class Solution_OPT {
  public:
    int distinctSubseq(string &str) {
        int sz=str.size(), mod=1e9+7;
        vector<long long>dp(sz+1, 0);
        vector<int>last(26, -1);
        dp[0]=1;
        for(int i=1; i<=sz; ++i){
            dp[i]=(2*dp[i-1])%mod;
            int curr=str[i-1]-'a';
            if(last[curr]!=-1){
                dp[i]=(dp[i]-dp[last[curr]-1]+mod)%mod;
            }
            last[curr]=i;
        }
        return dp[sz];
    }
};