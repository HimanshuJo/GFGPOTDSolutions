/*
https://www.geeksforgeeks.org/problems/armstrong-numbers2727/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
    string armstrongNumber(int n){
        int tochk=n, res=0;
        while(n>10){
            int rst=n/10, lstdgt=n%10;
            res+=(lstdgt*lstdgt*lstdgt);
            n=rst;
        }
        res+=n*n*n;
        return res==tochk?"Yes":"No";
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        Solution ob;
        cout << ob.armstrongNumber(n) << endl;
    }
    return 0;
}

// } Driver Code Ends