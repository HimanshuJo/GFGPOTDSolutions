/*
https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
*/

class Solution {
  public:
    vector<int> calculateSpan(vector<int>& arr) {
        int sz=arr.size();
        vector<int>res;
        stack<int>stk;
        for(int i=0; i<sz; ++i){
            int currprice=arr[i];
            while(!stk.empty()&&arr[stk.top()]<=currprice) stk.pop();
            int curcount=stk.empty()?i+1:(i-stk.top());
            res.push_back(curcount);
            stk.push(i);
        }
        return res;
    }
};