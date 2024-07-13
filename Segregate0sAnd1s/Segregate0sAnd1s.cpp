/*
https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1
*/

//{ Driver Code Starts
// Initial template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    void segregate0and1(vector<int> &arr) {
        int sz=arr.size(), idx=0;
        int countZeros=0;
        for(int i=0; i<sz; ++i){
            if(arr[i]==0) countZeros++;
        }
        while(countZeros--){
            arr[idx++]=0;
        }
        while(idx<=sz-1){
            arr[idx++]=1;
        }
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
        getline(cin, input);
        stringstream ss(input);
        int number;
        while (ss >> number) {
            arr.push_back(number);
        }
        int n = arr.size();
        Solution ob;
        ob.segregate0and1(arr);
        for (int i = 0; i < n; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends