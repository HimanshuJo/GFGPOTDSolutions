/*
https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
*/

class Solution {
    public void sort012(int[] arr) {
        int lengthOfArr=arr.length, count0=0, count1=0, count2=0;
        for(int num: arr){
            if(num==0) count0++;
            else if(num==1) count1++;
            else count2++;
        }
        int currentIndex=0;
        while(currentIndex<=lengthOfArr-1){
            while(count0-- >0){
                arr[currentIndex++]=0;
            }
            while(count1-- >0){
                arr[currentIndex++]=1;
            }
            while(count2-- >0){
                arr[currentIndex++]=2;
            }
        }
    }
}