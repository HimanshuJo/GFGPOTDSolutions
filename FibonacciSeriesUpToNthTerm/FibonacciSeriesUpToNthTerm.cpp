/*
https://www.geeksforgeeks.org/problems/fibonacci-series-up-to-nth-term/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    vector<int> Series(int n) {
        vector<int>res;
        int prev=0, curr=1, mod=1e9+7;
        res.push_back(prev);
        while(res.size()!=n+1){
            res.push_back(curr);
            int temp=curr;
            curr+=prev;
            curr%=mod;
            prev=temp;
        }
        return res;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution obj;

        vector<int> ans = obj.Series(n);
        for (auto x : ans) cout << x << " ";
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends