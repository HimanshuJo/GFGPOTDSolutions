/*
https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1
*/

//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
  public:

    string longestCommonPrefix(vector<string> arr) {
        sort(arr.begin(), arr.end());
        int sz=arr.size();
        string bgn=arr[0], res="";
        for(int i=0; i<bgn.size(); ++i){
            char curr=bgn[i];
            bool flag=false;
            for(int j=1; j<sz; ++j){
                if(arr[j][i]!=curr){
                    flag=true;
                    break;
                }
            }
            if(!flag) res+=curr;
            else break;
        }
        return res==""?"-1":res;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<string> arr;
        string input;
        getline(cin, input);
        stringstream ss(input);
        string number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        cout << ob.longestCommonPrefix(arr) << endl;
    }
}

// } Driver Code Ends