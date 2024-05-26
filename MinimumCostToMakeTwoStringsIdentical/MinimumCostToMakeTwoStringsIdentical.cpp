/*
https://www.geeksforgeeks.org/problems/minimum-cost-to-make-two-strings-identical1107/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {

  public:
  
    int dfs(string &x, string &y, int sz1, int sz2, vector<vector<int>>&memo){
        if(sz1==0||sz2==0) return 0;
        if(memo[sz1][sz2]!=-1) return memo[sz1][sz2];
        int res=0;
        if(x[sz1-1]==y[sz2-1]){
            res=max(res, 1+dfs(x, y, sz1-1, sz2-1, memo));
        } else{
            res=max(res, max(dfs(x, y, sz1-1, sz2, memo), dfs(x, y, sz1, sz2-1, memo)));
        }
        return memo[sz1][sz2]=res;
    }
  
    int findLCS(string &x, string &y){
        int sz1=x.size(), sz2=y.size();
        vector<vector<int>>memo(sz1+1, vector<int>(sz2+1, -1));
        return dfs(x, y, sz1, sz2, memo);
    }
  
    int findMinCost(string x, string y, int costX, int costY) {
        int lcs=findLCS(x, y);
        int sz1=x.size(), sz2=y.size(), res=0;
        int rem1=abs(lcs-sz1), rem2=abs(lcs-sz2);
        res+=(rem1*costX)+(rem2*costY);
        return res;
    }
};


//{ Driver Code Starts.
int main() {

    int t;
    cin >> t;
    while (t--) {
        string x, y;
        cin >> x >> y;

        int costX, costY;
        cin >> costX >> costY;

        Solution ob;
        cout << ob.findMinCost(x, y, costX, costY);
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends