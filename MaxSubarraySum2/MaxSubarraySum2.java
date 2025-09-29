/*
https://www.geeksforgeeks.org/problems/maximum-subarray-sum--110820/1
*/

class Solution {
    public int maxSubarrSum(int[] arr, int a, int b) {
        int lengthOfArr=arr.length, resultantMaxSum=Integer.MIN_VALUE;
        int[] prefixSum=new int[lengthOfArr+1];
        for(int i=0; i<=lengthOfArr; ++i){
            prefixSum[i]=0;
        }
        for(int i=0; i<lengthOfArr; ++i){
            prefixSum[i+1]=prefixSum[i]+arr[i];
        }
        Deque<Integer>deque=new ArrayDeque<>();
        for(int i=1; i<=lengthOfArr; ++i){
            if(i-a>=0){
                int idx=i-a;
                while(!deque.isEmpty()&&prefixSum[deque.getLast()]>prefixSum[idx]){
                    deque.pollLast();
                }
                deque.add(idx);
            }
            while(!deque.isEmpty()&&deque.getFirst()<i-b){
                deque.pollFirst();
            }
            if(!deque.isEmpty()){
                resultantMaxSum=Math.max(resultantMaxSum, prefixSum[i]-prefixSum[deque.getFirst()]);
            }
        }
        return resultantMaxSum;
    }
}