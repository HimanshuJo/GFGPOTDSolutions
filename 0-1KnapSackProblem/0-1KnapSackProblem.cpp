/*
https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
  
    long long dfs(int W, vector<int>&wt, vector<int>&val, int idx, vector<vector<int>>&memo){
        if(idx>=wt.size()) return 0;
        if(memo[W][idx]!=-1) return memo[W][idx];
        long long res=0, pk=0, ntpk=0;
        ntpk=dfs(W, wt, val, idx+1, memo);
        if(wt[idx]<=W){
            pk=val[idx]+dfs(W-wt[idx], wt, val, idx+1, memo);
            res=max(res, max(pk, ntpk));
        }
        res=max(res, max(pk, ntpk));
        return memo[W][idx]=res;
    }
  
    // Function to return max value that can be put in knapsack of capacity W.
    int knapSack(int W, vector<int>& wt, vector<int>& val) {
        int idx=0;
        vector<vector<int>>memo(W+1, vector<int>(wt.size()+1, -1));
        return dfs(W, wt, val, idx, memo);
    }
};



//{ Driver Code Starts.

int main() {
    // taking total testcases
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        // reading number of elements and weight
        int n, w;
        vector<int> arr, val, wt, drr;
        string ip;
        int number;
        getline(cin, ip);
        stringstream ss(ip);

        while (ss >> number) {
            arr.push_back(number);
        }

        getline(cin, ip);
        ss.clear();
        ss.str(ip);

        while (ss >> number) {
            val.push_back(number);
        }

        w = arr[0];
        n = val.size();
        getline(cin, ip);
        ss.clear();
        ss.str(ip);

        while (ss >> number) {
            wt.push_back(number);
        }
        Solution ob;
        cout << ob.knapSack(w, wt, val) << endl;
    }
    return 0;
}
// } Driver Code Ends