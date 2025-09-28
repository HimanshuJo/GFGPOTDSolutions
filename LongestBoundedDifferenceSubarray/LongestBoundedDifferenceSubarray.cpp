/*
https://www.geeksforgeeks.org/problems/longest-bounded-difference-subarray/1
*/

class Solution_TLE {
  public:
  
    bool isValid(vector<int>curr, int x){
        sort(curr.begin(), curr.end());
        int idx=0;
        while(idx+1<curr.size()){
            if(abs(curr[idx]-curr[idx+1])>x) return false;
            idx++;
        }
        if(abs(curr[0]-curr[curr.size()-1])>x) return false;
        return true;
    }
  
    vector<int> longestSubarray(vector<int>& arr, int x) {
        int sz=arr.size();
        vector<int>res;
        for(int i=0; i<sz; ++i){
            vector<int>curr;
            for(int j=i; j<sz; ++j){
                curr.push_back(arr[j]);
                if(isValid(curr, x)){
                    if(curr.size()>res.size()){
                        res=curr;
                    }
                } else break;
            }
        }
        return res;
    }
};

// ------- ******* -------

class Solution {
  public:
    vector<int> longestSubarray(vector<int>& arr, int x) {
        int sz=arr.size(), left=0, bestStart=0, bestLength=0;
        deque<int>maxDeque, minDeque;
        for(int right=0; right<sz; ++right){
            while(!maxDeque.empty()&&arr[maxDeque.back()]<arr[right]){
                maxDeque.pop_back();
            }
            maxDeque.push_back(right);
            while(!minDeque.empty()&&arr[minDeque.back()]>arr[right]){
                minDeque.pop_back();
            }
            minDeque.push_back(right);
            while(arr[maxDeque.front()]-arr[minDeque.front()]>x){
               left++;
               if(maxDeque.front()<left) maxDeque.pop_front();
               if(minDeque.front()<left) minDeque.pop_front();
            }
            if(right-left+1>bestLength){
                bestLength=right-left+1;
                bestStart=left;
            }
        }
        return vector<int>(arr.begin()+bestStart, arr.begin()+bestStart+bestLength);
    }
};