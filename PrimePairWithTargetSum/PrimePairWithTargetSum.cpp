/*
https://www.geeksforgeeks.org/problems/sum-of-prime4751/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
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
  
    void sieve(vector<int>&allPrimes, int n){
        vector<int>isPrime(n+10, true);
        isPrime[0]=false;
        isPrime[1]=false;
        for(int i=2; i*i<=n; ++i){
            if(isPrime[i]){
                for(int j=2; i*j<=n; ++j){
                    isPrime[i*j]=false;
                }
            }
        }
        for(int i=1; i<=n; ++i){
            if(isPrime[i]){
                allPrimes.push_back(i);
            }
        }
    }
  
    vector<int> getPrimes(int n) {
        vector<int>allPrimes;
        sieve(allPrimes, n);
        int left=0, right=allPrimes.size()-1;
        while(left<=right){
            int cursm=allPrimes[left]+allPrimes[right];
            if(cursm==n){
                return {allPrimes[left], allPrimes[right]};
            } else if(cursm>n){
                right-=1;
            } else left+=1;
        }
        return {-1, -1};
    }
};


//{ Driver Code Starts.

int main() {
    int t;
    scanf("%d ", &t);
    while (t--) {

        int n;
        scanf("%d", &n);

        Solution obj;
        vector<int> res = obj.getPrimes(n);

        Array::print(res);
    }
}

// } Driver Code Ends