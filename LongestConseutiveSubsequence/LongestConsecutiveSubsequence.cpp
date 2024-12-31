/*
https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1
*/

//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
class Solution {
  public:

    // Function to return length of longest subsequence of consecutive integers.
    int longestConsecutive(vector<int>& arr) {
        set<int>all;
        for(auto &vals: arr){
            all.insert(vals);
        }
        vector<int>newVec;
        for(auto &vals: all){
            newVec.push_back(vals);
        }
        int sz=newVec.size(), res=INT_MIN;
        for(int i=0; i<sz; ++i){
            int curr=newVec[i];
            if(i+1<=sz-1){
                int curidx=i+1, curlength=1;
                while(true){
                	if(curidx>=sz) break;
                    if(newVec[curidx]!=curr+1) break;
                    curr=newVec[curidx];
                    curlength++, curidx++;
                }
                res=max(res, curlength);
            }
        }
        return res;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;

        // Read first array
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }

        Solution ob;
        int res = ob.longestConsecutive(arr);

        cout << res << endl << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends