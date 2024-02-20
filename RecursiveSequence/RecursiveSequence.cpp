/*
https://www.geeksforgeeks.org/problems/recursive-sequence1611/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++

class Solution{
public:
    long long sequence(int n){
        int mod=1e9+7;
        long long res=1;
        int curcount=2, curnum=2;
        while(curcount<=n){
            int tmpcurcount=curcount;
            tmpcurcount--;
            long long curmul=curnum;
            curnum++;
            while(tmpcurcount--){
                curmul*=curnum++;
                curmul%=mod;
            }
            res+=curmul;
            res%=mod;
            curcount++;
        }
        return res;
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int N;
        cin>>N;
        
        Solution ob;
        cout<<ob.sequence(N)<<endl;
    }
    return 0;
}
// } Driver Code Ends