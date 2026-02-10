/*
https://www.geeksforgeeks.org/problems/koko-eating-bananas/1
*/

class Solution {
    public int kokoEat(int[] arr, int k) {
        int maxElement=Integer.MIN_VALUE;
        for(int num: arr){
            maxElement=Math.max(maxElement, num);
        }
        int low=1, high=maxElement, resultantMinValue=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            long hours=0;
            for(int vals: arr){
                hours+=(vals+mid-1)/mid;
                if(hours>k) break;
            }
            if(hours<=k){
                resultantMinValue=mid;
                high=mid-1;
            } else{
                low=mid+1;
            }
        }
        return resultantMinValue;
    }
}
