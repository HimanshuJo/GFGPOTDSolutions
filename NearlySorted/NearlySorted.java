/*
https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
*/

class Solution {
    public void nearlySorted(int[] arr, int k) {
        int lengthOfArr=arr.length;
        if(lengthOfArr==1) return;
        PriorityQueue<Integer>minHeap=new PriorityQueue<>();
        int initialIndex=0, minWindowSize=Math.min(k+1, lengthOfArr);
        for(; initialIndex<minWindowSize; ++initialIndex){
            minHeap.add(arr[initialIndex]);
        }
        int indexForTraversing=0;
        while(initialIndex<lengthOfArr){
            arr[indexForTraversing++]=minHeap.poll();
            minHeap.add(arr[initialIndex++]);
        }
        while(!minHeap.isEmpty()){
            arr[indexForTraversing++]=minHeap.poll();
        }
    }
}
