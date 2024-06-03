/*
https://www.geeksforgeeks.org/problems/trail-of-ones3242/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
  
    int mod=1000000007;
  
    int countConsNonOnes(int num, vector<int>&memo){
        if(num==1) return 2;
        if(num==2) return 3;
        if(memo[num]!=-1) return memo[num];
        int res=0;
        res+=countConsNonOnes(num-1, memo)+countConsNonOnes(num-2, memo);
        res%=mod;
        return memo[num]=res;
    }
    
    int countTotalOnes(int num, vector<int>&memo){
        if(num==1) return 2;
        if(memo[num]!=-1) return memo[num];
        int res=0;
        res+=(2*countTotalOnes(num-1, memo));
        res%=mod;
        return memo[num]=res;
        
    }
  
    int numberOfConsecutiveOnes(int n) {
        vector<int>memo1(n+1, -1), memo2(n+1, -1);
        int ttn=countTotalOnes(n, memo1), consNonn=countConsNonOnes(n, memo2);
        int res=(ttn-consNonn+mod)%mod;
        return res;
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int N;
        cin >> N;
        Solution ob;
        cout << ob.numberOfConsecutiveOnes(N) << endl;
    }
    return 0;
}

// } Driver Code Ends