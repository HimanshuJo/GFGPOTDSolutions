/*
https://www.geeksforgeeks.org/problems/k-closest-elements3619/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class CustomComparator{
    public:
    bool operator()(const int &A, const int &B){
        return A>B;
    }
};

class Solution {
  public:
    vector<int> printKClosest(vector<int> arr, int n, int k, int x) {
        map<int, set<int, CustomComparator>>mp;
        for(auto &vals: arr){
            mp[abs(vals-x)].insert(vals);
        }
        vector<int>res;
        set<int>seen;
        seen.insert(x);
        for(auto &entries: mp){
            for(auto &vals: entries.second){
                if(vals!=x){
                    res.push_back(vals);
                    seen.insert(vals);
                    if(res.size()==k) break;
                }
            }
            if(res.size()==k) break;
        }
        int idx=0;
        while(res.size()!=k){
            if(seen.find(arr[idx])==seen.end()){
                if(arr[idx]!=x){
                    res.push_back(arr[idx]);   
                }
            }
            idx++;
            if(idx>=n) break;
        }
        return res;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k, x;
        cin >> n;
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i];
        }
        cin >> k >> x;
        Solution ob;
        auto ans = ob.printKClosest(arr, n, k, x);
        for (auto e : ans) {
            cout << e << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends