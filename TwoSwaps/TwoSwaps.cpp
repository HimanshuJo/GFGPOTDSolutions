/*
https://www.geeksforgeeks.org/problems/two-swaps--155623/1
*/

//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    bool checkSorted(vector<int> &arr) {
        int sz=arr.size(), bgn=0, nm=1, count=0;
        for(int i=0; i<sz; ++i){
            auto itr=find(arr.begin(), arr.end(), nm);
            int idx=itr-arr.begin();
            if(idx!=bgn){
                if(count==2) return false;
                swap(arr[idx], arr[bgn]);
                count++;
            }
            bgn++, nm++;
        }
        return true;
    }
};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        string input;
        getline(cin, input);
        stringstream ss(input);
        int num;
        vector<int> arr;
        while (ss >> num)
            arr.push_back(num);

        Solution ob;
        bool ans = ob.checkSorted(arr);
        if (ans)
            cout << "true" << endl;
        else
            cout << "false" << endl;
    }
}

// } Driver Code Ends