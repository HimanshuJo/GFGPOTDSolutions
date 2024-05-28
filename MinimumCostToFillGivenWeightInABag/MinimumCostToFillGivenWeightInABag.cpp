/*
https://www.geeksforgeeks.org/problems/minimum-cost-to-fill-given-weight-in-a-bag1956/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

class Array {
  public:
    template <class T>
    static void input(vector<T> &A, int n) {
        for (int i = 0; i < n; i++) {
            scanf("%d ", &A[i]);
        }
    }

    template <class T>
    static void print(vector<T> &A) {
        for (int i = 0; i < A.size(); i++) {
            cout << A[i] << " ";
        }
        cout << endl;
    }
};


// } Driver Code Ends

class Solution {
  public:
  
    long long dfs(int n, int w, vector<int>&cost, vector<int>&weight, vector<vector<int>>&memo){
        if(w==0) return 0;
        if(n<=0||w<0) return INT_MAX;
        if(memo[n][w]!=-1) return memo[n][w];
        long long res=INT_MAX, pk=INT_MAX, ntpk=INT_MAX;
        if(cost[n-1]!=-1){
            ntpk=dfs(n-1, w, cost, weight, memo);
            res=min(res, min(pk, ntpk));
        }
        if(weight[n-1]<=w){
            pk=cost[n-1]+dfs(n, w-weight[n-1], cost, weight, memo);
            ntpk=dfs(n-1, w, cost, weight, memo);
            res=min(res, min(pk, ntpk));
        } else{
            ntpk=dfs(n-1, w, cost, weight, memo);
            res=min(res, min(pk, ntpk));
        }
        return memo[n][w]=res;
    }
  
    int minimumCost(int n, int w, vector<int> &cost) {
        vector<int>weight(n);
        for(int i=0; i<n; ++i){
            weight[i]=i+1;
        }
        vector<vector<int>>memo(n+1, vector<int>(w+1, -1));
        int fnres=dfs(n, w, cost, weight, memo);
        return fnres>=INT_MAX?-1:fnres;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int n;
        scanf("%d", &n);

        int w;
        scanf("%d", &w);

        vector<int> cost(n);
        Array::input(cost, n);

        Solution obj;
        int res = obj.minimumCost(n, w, cost);

        cout << res << endl;
    }
}

// } Driver Code Ends