/*
https://www.geeksforgeeks.org/problems/k-pangrams0909/1
*/

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:

    bool kPangram(string str, int k) {
        vector<char>nothave;
        unordered_map<char, char>mp;
        for(char ch='a'; ch<='z'; ++ch){
            mp[ch]=ch;
        }
        for(auto &entries: mp){
            if(find(str.begin(), str.end(), entries.first)==str.end()){
                nothave.push_back(entries.first);
            }
        }
        unordered_set<char>seen;
        for(int i=0; i<str.size(); ++i){
            if(mp.find(str[i])!=mp.end()){
                if(seen.find(str[i])!=seen.end()){
                    str[i]='#';
                }
                seen.insert(str[i]);   
            }
        }
        if(nothave.size()==0) return true;
        int idx=0;
        for(auto &ch: str){
            if(ch=='#'){
                if(k==0) break;
                ch=nothave[idx++];
                if(idx>=nothave.size()) break;
                k--;
            }
        }
        return idx>=nothave.size();
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        cin.ignore();
        string str;
        getline(cin, str);

        int k;
        cin >> k;

        Solution ob;
        bool a = ob.kPangram(str, k);
        if (a)
            cout << "true" << endl;
        else
            cout << "false" << endl;
    }
    return 0;
}
// } Driver Code Ends