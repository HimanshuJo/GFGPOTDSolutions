/*
https://www.geeksforgeeks.org/problems/rotate-by-90-degree0356/1
*/

//{ Driver Code Starts
// Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function template for C++

/* matrix : given input matrix, you are require
 to change it in place without using extra space */
void rotate(vector<vector<int> >& mat) {
    int rws=mat.size(), cols=mat[0].size();
    vector<vector<int>>tmp(rws, vector<int>(cols, 0));
    int idx=0;
    for(int i=rws-1; i>=0; --i){
        vector<int>curr=mat[i];
        for(int j=0; j<cols; ++j){
            tmp[j][idx]=curr[j];
        }
        idx++;
    }
    mat=tmp;
}


//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<vector<int> > matrix(n);
        for (int i = 0; i < n; i++) {
            matrix[i].resize(n);
            for (int j = 0; j < n; j++)
                cin >> matrix[i][j];
        }
        rotate(matrix);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; j++)
                cout << matrix[i][j] << " ";
            cout << "\n";
        }

        cout << "~"
             << "\n";
    }
    return 0;
}

// } Driver Code Ends