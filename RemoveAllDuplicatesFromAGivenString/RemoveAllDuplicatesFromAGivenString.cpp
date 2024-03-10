/*
https://www.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:
	string removeDuplicates(string str) {
	    string res="";
	    unordered_map<char, char>mp;
	    for(char &ch: str){
	        if(mp.find(ch)==mp.end()){
	            res+=ch;
	            mp[ch]=ch;
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
        string str;
        cin >> str;
        Solution ob;
        auto ans = ob.removeDuplicates(str);

        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends