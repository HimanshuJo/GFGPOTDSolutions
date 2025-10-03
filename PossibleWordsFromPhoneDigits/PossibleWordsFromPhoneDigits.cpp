/*
https://www.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1
*/

class Solution {
  public:
  
    void dfs(vector<int>&arr, map<int, string>&mp, const int sz, string &curr, vector<string>&res, int idx){
        if(idx>=sz){
            res.push_back(curr);
            return;
        }
        int digit = arr[idx];
        if (digit == 0 || digit == 1) {
            dfs(arr, mp, sz, curr, res, idx + 1);
            return;
        }
        string currLetters = mp[digit];
        for (char c : currLetters) {
            curr.push_back(c);
            dfs(arr, mp, sz, curr, res, idx + 1);
            curr.pop_back();
        }
        return;
    }
  
    vector<string> possibleWords(vector<int> &arr) {
        map<int, string>mp;
        mp[1]="";
        mp[2]="abc";
        mp[3]="def";
        mp[4]="ghi";
        mp[5]="jkl";
        mp[6]="mno";
        mp[7]="pqrs";
        mp[8]="tuv";
        mp[9]="wxyz";
        int sz=arr.size();
        string curr="";
        vector<string>res;
        dfs(arr, mp, sz, curr, res, 0);
        return res;
    }
};