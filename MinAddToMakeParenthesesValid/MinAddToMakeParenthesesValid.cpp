/*
https://www.geeksforgeeks.org/problems/min-add-to-make-parentheses-valid/1
*/

class Solution {
  public:
    int minParentheses(string& s) {
        int sz=s.size(), res=0;
        stack<char>stk;
        for(int i=0; i<sz; ++i){
            if(s[i]=='('){
                stk.push(s[i]);
            } else{
                if(stk.size()>=1){
                    stk.pop();
                } else res++;
            }
        }
        res+=stk.size();
        return res;
    }
};