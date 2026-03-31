/*
https://www.geeksforgeeks.org/problems/buy-stock-with-transaction-fee/1
*/

class Solution_TLE {
    
    int depthFirstSearch_forArrays(int arr[], int k, int lengthOfArr, int currentIndex, boolean holdingTheStock){
        if(currentIndex>=lengthOfArr) return 0;
        if(!holdingTheStock){
            int buy=-arr[currentIndex]+depthFirstSearch_forArrays(arr, k, lengthOfArr, currentIndex, true);
            int skip=depthFirstSearch_forArrays(arr, k, lengthOfArr, currentIndex+1, false);
            return Math.max(buy, skip);
        } else{
            int sell=arr[currentIndex]-k+depthFirstSearch_forArrays(arr, k, lengthOfArr, currentIndex+1, false);
            int skip=depthFirstSearch_forArrays(arr, k, lengthOfArr, currentIndex+1, true);
            return Math.max(sell, skip);
        }
    }
    
    public int maxProfit(int arr[], int k) {
        int lengthOfArr=arr.length, currentIndex=0;
        boolean holdingTheStock=false;
        return depthFirstSearch_forArrays(arr, k, lengthOfArr, currentIndex, holdingTheStock);
    }
}