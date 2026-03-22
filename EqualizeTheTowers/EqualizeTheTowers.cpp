/*
https://www.geeksforgeeks.org/problems/equalize-the-towers2804/1
*/

class Solution {
  public:
    int minCost(vector<int>& heights, vector<int>& cost) {
        vector<pair<int, int>>heightCostPair;
        int sz=heights.size();
        for(int i=0; i<sz; ++i){
            heightCostPair.push_back({heights[i], cost[i]});
        }
        sort(heightCostPair.begin(), heightCostPair.end());
        long long totalWeight=0, medianHeight=0, cumulativeWeight=0;
        for(int i=0; i<sz; ++i){
            totalWeight+=heightCostPair[i].second;
        }
        for(int i=0; i<sz; ++i){
            cumulativeWeight+=heightCostPair[i].second;
            if(2*cumulativeWeight>=totalWeight){
                medianHeight=heightCostPair[i].first;
                break;
            }
        }
        int res=0;
        for(int i=0; i<sz; ++i){
            res+=abs(heights[i]-medianHeight)*cost[i];
        }
        return res;
    }
};
