/*
https://www.geeksforgeeks.org/problems/index-of-an-extra-element/1
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    
    int binarySearch(int n, int arr1[], int arr2[]){
        int left=0, right=n-2, res=n-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr2[mid]>arr1[mid]){
                res=mid;
                right=mid-1;
            } else if(arr2[mid]<arr1[mid]){
                right=mid-1;
            } else left=mid+1;
        }
        return res;
    }
    
    int findExtra(int n, int arr1[], int arr2[]) {
        return binarySearch(n, arr1, arr2);
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        int arr1[n], arr2[n - 1];
        for (int i = 0; i < n; i++) {
            cin >> arr1[i];
        }
        for (int i = 0; i < n - 1; i++) {
            cin >> arr2[i];
        }
        Solution obj;
        cout << obj.findExtra(n, arr1, arr2) << endl;
    }
}
// } Driver Code Ends