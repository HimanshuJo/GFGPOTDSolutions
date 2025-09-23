/*
https://www.geeksforgeeks.org/problems/queue-reversal/1
*/

class Solution {
    public void reverseQueue(Queue<Integer> q) {
        Stack<Integer>stack=new Stack();
        while(!q.isEmpty()){
            stack.add(q.poll());
        }
        while(!stack.isEmpty()){
            q.add(stack.pop());
        }
    }
}