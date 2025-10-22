/*
https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
*/

class Solution {
  public:
    void nearlySorted(vector<int>& arr, int k) {
        int sz=arr.size();
        if(sz==1) return;
        priority_queue<int, vector<int>, greater<>>pq;
        int idx=0, minWindowSize=min(k+1, sz);
        for(; idx<minWindowSize; ++idx){
            pq.push(arr[idx]);
        }
        int idx2=0;
        while(idx<sz){
            arr[idx2++]=pq.top();
            pq.pop();
            pq.push(arr[idx++]);
        }
        while(!pq.empty()){
            arr[idx2++]=pq.top();
            pq.pop();
        }
    }
};