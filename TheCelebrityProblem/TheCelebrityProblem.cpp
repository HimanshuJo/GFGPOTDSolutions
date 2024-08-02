/*
https://www.geeksforgeeks.org/problems/the-celebrity-problem/1
*/

//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

class Solution {
  public:
    // Function to find if there is a celebrity in the party or not.
    int celebrity(vector<vector<int> >& mat) {
        int rws=mat.size(), cols=mat[0].size();
        if(rws==1) return 0;
        map<int, vector<int>>mp1, mp2;
        for(int i=0; i<rws; ++i){
            for(int j=0; j<cols; ++j){
                if(mat[i][j]==1){
                    mp1[j].push_back(i);
                    mp2[i].push_back(j);
                }
            }
        }
        for(int i=0; i<rws; ++i){
            if(mp2.find(i)==mp2.end()){
                if(mp1.find(i)!=mp1.end()){
                    auto tochk=mp1[i];
                    bool flag=false;
                    for(int j=0; j<cols; ++j){
                        if(i!=j){
                            if(find(tochk.begin(), tochk.end(), j)==tochk.end()){
                                flag=true;
                                break;
                            }
                        }
                    }
                    if(!flag) return i;   
                }
            }
        }
        return -1;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int> > M(n, vector<int>(n, 0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> M[i][j];
            }
        }
        Solution ob;
        cout << ob.celebrity(M) << endl;
    }
}

// } Driver Code Ends