/*
https://www.geeksforgeeks.org/problems/you-and-your-books/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
#include <algorithm>
#include <cstdio>
#include <iostream>
//#include<Windows.h>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    /*You are requried to complete this method */
    long long max_Books(int arr[], int n, int k) {
        long long res=0;
        for(int i=0; i<n; ++i){
            int curr=arr[i], idx=i;
            long long curres=0;
            bool flag=false;
            while(true){
                if(curr>k||idx>=n) break;
                curres+=arr[idx++];
                curr=arr[idx];
                if(!flag) flag=true;
            }
            if(flag) i=(idx-1);
            res=max(res, curres);
        }
        return res;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        int ar[n];
        for (int i = 0; i < n; i++) {
            cin >> ar[i];
        }
        Solution ob;
        cout << ob.max_Books(ar, n, k) << endl;
    }
    return 0;
}

// } Driver Code Ends