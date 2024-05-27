/*
https://www.geeksforgeeks.org/problems/longest-subsequence-such-that-difference-between-adjacents-is-one4724/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
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
  
    int dfs(int n, vector<int>&a, int curr, int idx){
        if(idx>=n) return 0;
        int res=0, pk=0, ntpk=0;
        if(abs(a[idx]-curr)==1){
            int ele=a[idx];
            pk=1+dfs(n, a, ele, idx+1);
            ntpk=dfs(n, a, curr, idx+1);
            res=max(res, max(pk, ntpk));
        } else{
            ntpk=dfs(n, a, curr, idx+1);
            res=max(res, max(pk, ntpk));
        }
        return res;
    }
  
    int longestSubseq(int n, vector<int> &a) {
        int res=0;
        for(int i=0; i<n; ++i){
            int curr=a[i], curres=1;
            int toad=dfs(n, a, curr, i);
            curres+=toad;
            res=max(res, curres);
        }
        return res;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int n;
        scanf("%d", &n);

        vector<int> a(n);
        Array::input(a, n);

        Solution obj;
        int res = obj.longestSubseq(n, a);

        cout << res << endl;
    }
}

// } Driver Code Ends