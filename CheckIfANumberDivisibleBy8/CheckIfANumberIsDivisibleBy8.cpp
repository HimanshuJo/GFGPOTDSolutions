/*
https://www.geeksforgeeks.org/problems/check-if-a-number-is-divisible-by-83957/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends

class Solution{
    public:
    int DivisibleByEight(string s){
        int sz=s.size();
        string tochk="";
        if((s[sz-1]-'0')%2!=0) return -1;
        if(sz<=3){
            if(stoi(s)%8==0) return 1;
            return -1;
        }
        tochk+=s[sz-3], tochk+=s[sz-2], tochk+=s[sz-1];
        if(stoi(tochk)%8==0) return 1;
        return -1;
    }
};

//{ Driver Code Starts.
int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        string S;
        cin>>S;
        Solution ob;
        cout<<ob.DivisibleByEight(S)<<"\n";
    }
}
// } Driver Code Ends