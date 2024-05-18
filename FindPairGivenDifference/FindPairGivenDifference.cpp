/*
https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

class Array {
  public:
    template <class T>
    static void input(vector<T> &A, int n) {
        for (int i = 0; i < n; i++) {
            scanf("%d ", &A[i]);
        }
    }

    template <class T>
    static void print(vector<T> &A) {
        for (int i = 0; i < A.size(); i++) {
            cout << A[i] << " ";
        }
        cout << endl;
    }
};


// } Driver Code Ends

class Solution {
  public:
  
    int binarySearch(int val, vector<int>&arr, int idx){
        int left=0, right=arr.size()-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==val&&mid!=idx){
                return 1;
            } else if(arr[mid]>val){
                right=mid-1;
            } else left=mid+1;
        }
        return -1;
    }
  
    int findPair(int n, int x, vector<int> &arr) {
        sort(arr.begin(), arr.end());
        for(int i=0; i<n; ++i){
            int curr=arr[i], tofnd=curr+x;
            int flag=binarySearch(tofnd, arr, i);
            if(flag!=-1) return 1;
        }
        return -1;
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int n;
        scanf("%d", &n);

        int x;
        scanf("%d", &x);

        vector<int> arr(n);
        Array::input(arr, n);

        Solution obj;
        int res = obj.findPair(n, x, arr);

        cout << res << endl;
    }
}

// } Driver Code Ends