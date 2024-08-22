/*
https://www.geeksforgeeks.org/problems/split-an-array-into-two-equal-sum-subarrays/1
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    bool canSplit(vector<int>& arr) {
        int sz=arr.size();
        vector<int>prefixSum, suffixSum;
        prefixSum.push_back(arr[0]);
        for(int i=1; i<sz; ++i){
            prefixSum.push_back(prefixSum.back()+arr[i]);   
        }
        suffixSum.push_back(arr[sz-1]);
        for(int i=sz-2; i>=0; --i){
            suffixSum.push_back(suffixSum.back()+arr[i]);
        }
        reverse(suffixSum.begin(), suffixSum.end());
        for(int i=0; i<sz-1; ++i){
            int currPrefixSum=prefixSum[i], currSuffixSum=suffixSum[i+1];
            if(currPrefixSum==currSuffixSum) return true;
        }
        return false;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t-- > 0) {
        string s;
        getline(cin, s);
        stringstream ss(s);
        vector<int> arr;
        string temp;
        while (ss >> temp) {
            arr.push_back(stoi(temp));
        }

        Solution obj;
        bool res = obj.canSplit(arr);
        cout << (res ? "true" : "false") << endl;
    }
    return 0;
}
// } Driver Code Ends