/*
https://www.geeksforgeeks.org/problems/queue-reversal/1
*/

class Solution {
  public:
    void reverseQueue(queue<int> &q) {
        stack<int>stk;
        while(!q.empty()){
            stk.push(q.front());
            q.pop();
        }
        while(!stk.empty()){
            q.push(stk.top());
            stk.pop();
        }
    }
};