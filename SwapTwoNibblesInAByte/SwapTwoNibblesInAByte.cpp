/*
https://www.geeksforgeeks.org/problems/swap-two-nibbles-in-a-byte0446/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

/*
TLE: 221 / 1115

class Solution {
  public:
  
    int toDecimal(string str){
        int len=str.size(), pwr=len-1, res=0;
        for(int i=0; i<len; ++i){
            res+=(str[i]-'0')*(pow(2, pwr--));
        }
        return res;
    }
  
    string toBinary(int n){
        string res="";
        while(n!=1){
            int quo=n/2, rem=n%2;
            res+=to_string(rem);
            n=quo;
        }
        res+="1";
        while(res.size()!=8){
            res.push_back('0');
        }
        reverse(res.begin(), res.end());
        return res;
    }
  
    int swapNibbles(int n) {
        string toBn=toBinary(n), frst="", sec="";
        int len=toBn.size();
        for(int i=0; i<len/2; ++i){
            frst+=toBn[i];
        }
        for(int i=len/2; i<len; ++i){
            sec+=toBn[i];
        }
        return toDecimal(sec+frst);
    }
};
*/


// } Driver Code Ends
class Solution {
  public:
    int swapNibbles(int n) {
        int lowerNibble=(n&0x0F)<<4, upperNibble=(n&0xF0)>>4;
        return lowerNibble|upperNibble;
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
        cout << ob.swapNibbles(n) << endl;
    }
    return 0;
}
// } Driver Code Ends