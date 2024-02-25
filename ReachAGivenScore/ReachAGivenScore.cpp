/*
https://www.geeksforgeeks.org/problems/reach-a-given-score-1587115621/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

/*
TLE: 10 /1120

class Solution
{
    public:
    
    long long int dfs(long long int n, string curr, map<string, int>&memo){
        if(n<0) return 0;
        sort(curr.begin(), curr.end());
        if(memo.find(curr)!=memo.end()) return 0;
        if(n==0){
            memo[curr]=1;
            return 1;
        }
        int pk3=0, pk5=0, pk10=0;
        if(n-3>=0){
            curr+="3";
            pk3=dfs(n-3, curr, memo);
        }
        if(n-5>=0){
            curr+="5";
            pk5=dfs(n-5, curr, memo);
        }
        if(n-10>=0){
            curr+="10";
            pk10=dfs(n-10, curr, memo);
        }
        memo[curr]=pk3+pk5+pk10;
        return memo[curr];
    }
    
    // Complete this function
    long long int count(long long int n)
    {
        map<string, int>memo;
        string curr="";
    	return dfs(n, curr, memo);
    	
    }
};
*/

//{ Driver Code Starts
// Driver Code
#include<bits/stdc++.h>
#define ll long long int
using namespace std;

// } Driver Code Ends

class Solution
{
    public:
    // Complete this function
    long long int count(long long int n)
    {
        vector<int>dp(n+1, 0);
        dp[0]=1;
    	for(int i=3; i<=n; ++i){
    	    dp[i]+=dp[i-3];
    	}
    	for(int i=5; i<=n; ++i){
    	    dp[i]+=dp[i-5];
    	}
    	for(int i=10; i<=n; ++i){
    	    dp[i]+=dp[i-10];
    	}
    	return dp[n];
    }
};

//{ Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		ll n;
		cin>>n;
		Solution obj;
		cout<<obj.count(n)<<endl;
	}
	return 0;
}
// } Driver Code Ends