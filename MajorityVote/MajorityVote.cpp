/*
https://www.geeksforgeeks.org/problems/majority-vote/1
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    // Function to find the majority elements in the array
    vector<int> findMajority(vector<int>& nums) {
        map<int, int>mp;
        set<int>res;
        int sz=nums.size();
        for(auto &vals: nums){
            mp[vals]++;
            if(mp[vals]>sz/3) res.insert(vals);
        }
        vector<int>fnres(res.begin(), res.end());
        int fnressz=fnres.size();
        if(fnressz==0) return {-1};
        return fnres;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {

        string s;
        getline(cin, s);
        stringstream ss(s);
        vector<int> nums;
        int num;
        while (ss >> num) {
            nums.push_back(num);
        }
        Solution ob;
        vector<int> ans = ob.findMajority(nums);
        for (auto &i : ans)
            cout << i << " ";
        cout << "\n";
    }
    return 0;
}
// } Driver Code Ends