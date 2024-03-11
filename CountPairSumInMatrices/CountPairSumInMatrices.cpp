/*
https://www.geeksforgeeks.org/problems/count-pairs-sum-in-matrices4332/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts

#include <bits/stdc++.h>
using namespace std;



// } Driver Code Ends
//User function template for C++
class Solution{
public:	
	
	int countPairs(vector<vector<int>> &mat1, vector<vector<int>> &mat2, int n, int x)
	{
	    int res=0;
	    map<int, int>mp;
	    for(int rwsmat2=0; rwsmat2<n; ++rwsmat2){
	        mp[mat2[rwsmat2][n-1]]=rwsmat2;
        }
	    for(int rws=0; rws<n; ++rws){
	        for(int cols=0; cols<n; ++cols){
	            int cursm=mat1[rws][cols];
	            if(x-cursm>=0){
 	                auto itr=mp.lower_bound(x-cursm);
    	            if(itr!=mp.end()){
    	                int rwsmat2=itr->second;
    	                for(; rwsmat2<n; ++rwsmat2){
        	                for(int colsmat2=0; colsmat2<n; ++colsmat2){
        	                    if(mat1[rws][cols]+mat2[rwsmat2][colsmat2]==x) res++;
        	                    else if(mat1[rws][cols]+mat2[rwsmat2][colsmat2]>x) break;
        	                }
        	            }
    	            }   
	            }
	        }
	    }
	    return res;
	}
};

//{ Driver Code Starts.


int main() 
{

   	ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);
   
   	int t;
    cin >> t;
    while (t--)
    {
        int n, x;
        cin >> n >> x;

        vector<vector<int>> mat1(n, vector<int>(n, -1));
        vector<vector<int>> mat2(n, vector<int>(n, -1));

        for(int i = 0; i < n; i++)
        {
        	for(int j = 0; j < n; j++)
        	{
        		cin >> mat1[i][j];
        	}
        }

        for(int i = 0; i < n; i++)
        {
        	for(int j = 0; j < n; j++)
        	{
        		cin >> mat2[i][j];
        	}
        }

        Solution ob;

        cout << ob.countPairs(mat1, mat2, n, x) << "\n";

    }

    return 0;
}
// } Driver Code Ends