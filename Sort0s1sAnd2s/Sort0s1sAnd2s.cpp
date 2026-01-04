/*
https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
*/

class Solution {
  public:
    void sort012(vector<int>& arr) {
        int sz=arr.size(), count0=0, count1=0, count2=0;
        for(auto &vals: arr){
            if(vals==0) count0++;
            else if(vals==1) count1++;
            else count2++;
        }
        int idx=0;
        while(idx<=sz-1){
            while(count0--){
                arr[idx++]=0;
            }
            while(count1--){
                arr[idx++]=1;
            }
            while(count2--){
                arr[idx++]=2;
            }
        }
    }
};