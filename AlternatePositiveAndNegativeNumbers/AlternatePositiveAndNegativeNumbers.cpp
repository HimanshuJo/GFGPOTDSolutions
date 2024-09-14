/*
https://www.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1
*/

//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:

    void rearrange(vector<int> &arr) {
        int sz=arr.size();
        vector<int>positives, negatives;
        for(auto &vals: arr){
            if(vals>=0) positives.push_back(vals);
            else negatives.push_back(vals);
        }
        int idx1=0, idx2=0;
        for(int i=0; i<sz; ++i){
            if(i%2==0){
                if(positives.size()>=1&&idx1<=positives.size()-1){
                    arr[i]=positives[idx1++];
                } else{
                    arr[i]=negatives[idx2++];
                }
            } else{
                if(negatives.size()>=1&&idx2<=negatives.size()-1){
                    arr[i]=negatives[idx2++];
                } else{
                    arr[i]=positives[idx1++];
                }
            }
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
        int num;

        getline(cin, input);
        stringstream s2(input);
        while (s2 >> num) {
            arr.push_back(num);
        }
        Solution ob;
        ob.rearrange(arr);
        for (int i = 0; i < arr.size(); i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends