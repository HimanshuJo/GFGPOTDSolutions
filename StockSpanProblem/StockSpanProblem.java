/*
https://www.geeksforgeeks.org/problems/stock-span-problem-1587115621/1
*/

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int lengthOfArr=arr.length;
        ArrayList<Integer>resultantSpan=new ArrayList<>();
        Stack<Integer>stackOfIndices=new Stack<>();
        for(int i=0; i<lengthOfArr; ++i){
            int currentPrice=arr[i];
            while(!stackOfIndices.isEmpty()&&arr[stackOfIndices.peek()]<=currentPrice){
                stackOfIndices.pop();
            }
            int currentCount=stackOfIndices.isEmpty()?i+1:(i-stackOfIndices.peek());
            resultantSpan.add(currentCount);
            stackOfIndices.add(i);
        }
        return resultantSpan;
    }
}