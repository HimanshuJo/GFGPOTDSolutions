/*
https://www.geeksforgeeks.org/problems/word-break1352/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++

// s : given string to search
// dictionary : vector of available strings

class Solution
{
public:

    int dfs(string s, vector<string>&dictionary, int curidx, string &curr){
        if(curidx>=s.length()){
            auto itr=find(dictionary.begin(), dictionary.end(), curr);
            if(itr==dictionary.end()) return 0;
            return 1;
        }
        string nw1="";
        nw1+=s[curidx];
        string nw2=curr+s[curidx];
        auto itr=find(dictionary.begin(), dictionary.end(), curr);
        int pk=0, ntpk=0;
        if(itr!=dictionary.end()){
            pk=dfs(s, dictionary, curidx+1, nw1);
            ntpk=dfs(s, dictionary, curidx+1, nw2);
        } else ntpk=dfs(s, dictionary, curidx+1, nw2);
        return pk||ntpk;
    }

    int wordBreak(int n, string s, vector<string> &dictionary) {
        string curr="";
        return dfs(s, dictionary, 0, curr);
    }
};

//{ Driver Code Starts.

int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        vector<string> dictionary;
        for(int i=0;i<n;i++){
            string S;
            cin>>S;
            dictionary.push_back(S);
        }
        string s;
        cin>>s;
        Solution ob;
        cout<<ob.wordBreak(n, s, dictionary)<<"\n";
    }
}

// } Driver Code Ends