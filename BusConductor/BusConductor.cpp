/*
https://www.geeksforgeeks.org/problems/bus-conductor--170647/1
*/

class Solution {
  public:
    int findMoves(vector<int>& chairs, vector<int>& passengers) {
        sort(chairs.begin(), chairs.end());
        sort(passengers.begin(), passengers.end());
        int sz=chairs.size(), res=0;
        for(int i=0; i<sz; ++i){
            res+=abs(passengers[i]-chairs[i]);
        }
        return res;
    }
};