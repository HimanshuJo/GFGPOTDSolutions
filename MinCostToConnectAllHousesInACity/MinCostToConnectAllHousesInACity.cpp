/*
https://www.geeksforgeeks.org/problems/minimum-cost-to-connect-all-houses-in-a-city/1
*/

class Solution {
  public:
    int minCost(vector<vector<int>>& houses) {
        int n=houses.size(), res=0;
        vector<int>minDist(n, INT_MAX);
        vector<bool>seen(n, false);
        minDist[0]=0;
        for(int i=0; i<n; ++i){
            int u=-1;
            for(int j=0; j<n; ++j){
                if(seen[j]==false&&(u==-1||(minDist[j]<minDist[u]))){
                    u=j;
                }
            }
            seen[u]=true;
            res+=minDist[u];
            for(int v=0; v<n; ++v){
                if(seen[v]==false){
                    int dist=abs(houses[u][0]-houses[v][0])+abs(houses[u][1]-houses[v][1]);
                    minDist[v]=min(minDist[v], dist);
                }
            }
        }
        return res;
    }
};