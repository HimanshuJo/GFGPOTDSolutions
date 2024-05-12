/*
https://www.geeksforgeeks.org/problems/juggler-sequence3930/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    vector<long long> jugglerSequence(long long n) {
        vector<long long>res;
        res.push_back(n);
        while(n!=1){
            if(n%2==0){
                auto curr=pow(n, 0.5);
                res.push_back(curr);
                n=curr;
            } else{
                auto curr=pow(n, 1.5);
                res.push_back(curr);
                n=curr;
            }
        }
        return res;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        long long n;
        cin >> n;

        Solution ob;
        vector<long long> ans = ob.jugglerSequence(n);
        for (long long u : ans)
            cout << u << " ";
        cout << endl;
    }
    return 0;
}
// } Driver Code Ends