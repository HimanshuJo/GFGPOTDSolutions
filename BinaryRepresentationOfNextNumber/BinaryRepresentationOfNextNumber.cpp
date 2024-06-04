/*
https://www.geeksforgeeks.org/problems/binary-representation-of-next-number3648/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    string binaryNextNumber(string s) {
        string fnstr="";
        int idx=0, sz=s.size();
        while(true){
            if(s[idx]!='0') break;
            idx++;
        }
        for(int i=idx; i<sz; ++i){
            fnstr+=s[i];
        }
        int nwsz=fnstr.size();
        for(int i=nwsz-1; i>=0; --i){
            if(fnstr[i]=='0'){
                fnstr[i]='1';
                return fnstr;
            } else{
                fnstr[i]='0';
            }
        }
        fnstr.insert(fnstr.begin(), '1');
        return fnstr;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string s;
        cin >> s;
        Solution ob;
        cout << ob.binaryNextNumber(s);
        cout << "\n";
    }

    return 0;
}
// } Driver Code Ends