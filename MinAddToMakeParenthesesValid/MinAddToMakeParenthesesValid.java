/*
https://www.geeksforgeeks.org/problems/min-add-to-make-parentheses-valid/1
*/

class Solution {
    public int minParentheses(String s) {
        int lengthOfS=s.length(), resultantMinParenthesesReq=0;
        Stack<Character>bracketsStack=new Stack<>();
        for(int i=0; i<lengthOfS; ++i){
            if(s.charAt(i)=='('){
                bracketsStack.add(s.charAt(i));
            } else{
                if(!bracketsStack.empty()){
                    bracketsStack.pop();
                } else resultantMinParenthesesReq++;
            }
        }
        resultantMinParenthesesReq+=(int)bracketsStack.size();
        return resultantMinParenthesesReq;
    }
}
