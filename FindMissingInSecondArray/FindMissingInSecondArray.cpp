/*
https://www.geeksforgeeks.org/problems/in-first-but-second5423/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	
	
	public:
	vector<int> findMissing(int a[], int b[], int n, int m) 
	{ 
	    vector<int>res;
	    unordered_map<int, int>mp1, mp2;
	    for(int i=0; i<n; ++i){
	        mp1[a[i]]++;
	    }
	    for(int i=0; i<m; ++i){
	        mp1[b[i]]++;
	        mp2[b[i]]++;
	    }
	    for(int i=0; i<n; ++i){
	        if(mp1[a[i]]==1) res.push_back(a[i]);
	        else if(mp2.find(a[i])==mp2.end()) res.push_back(a[i]);
	    }
	    return res;
	} 
};
	

//{ Driver Code Starts.

int main() 
{
   	
   
   	int t;
    cin >> t;
    while (t--)
    {
    	int n;
        cin>>n;
        int m;
        cin>>m;
        int a[n];
        int b[m];
        for(int i=0;i<n;i++)
        cin>>a[i];
        for(int i=0;i<m;i++)
        cin >> b[i];
        vector<int> ans;
        

        Solution ob;
        ans=ob.findMissing(a,b,n,m);
        for(int i=0;i<ans.size();i++)
        cout<<ans[i]<<" ";
	    
        
	    cout << "\n";
	     
    }
    return 0;
}
// } Driver Code Ends