/*
https://www.geeksforgeeks.org/problems/roof-top-1587115621/1
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    int maxStep(vector<int>& arr) {
        int sz=arr.size(), res=INT_MIN;
        for(int i=0; i<sz; ++i){
            int curstep=arr[i], curjmp=0;
            if(i+1<=sz-1){
                for(int j=i+1; j<sz; ++j){
                    if(arr[j]>curstep){
                        curstep=arr[j];
                        curjmp++;
                    } else break;
                }
            }
            res=max(res, curjmp);
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
        getline(cin, input); // Read the entire line for the array elements
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        Solution ob;
        cout << ob.maxStep(arr) << endl;
    }
    return 0;
}
// } Driver Code Ends