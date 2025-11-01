/*
https://www.geeksforgeeks.org/problems/shortest-cycle/1
*/

class Solution {
  public:
    int shortCycle(int V, vector<vector<int>>& edges) {
        vector<vector<int>>adj(V);
        for(auto &edge: edges){
            int src=edge[0], dest=edge[1];
            adj[src].push_back(dest);
            adj[dest].push_back(src);
        }
        int res=INT_MAX;
        for(int node=0; node<V; ++node){
            vector<int>dist(V, -1);
            vector<int>parent(V, -1);
            queue<int>q;
            q.push(node);
            dist[node]=0;
            while(!q.empty()){
                int sz=q.size();
                while(sz--){
                    auto curr=q.front();
                    q.pop();
                    for(auto &nei: adj[curr]){
                        if(dist[nei]==-1){
                            dist[nei]=dist[curr]+1;
                            parent[nei]=curr;
                            q.push(nei);
                        } else if(parent[curr]!=nei){
                            int curDist=dist[curr]+dist[nei]+1;
                            res=min(res, curDist);
                        }
                    }
                }
            }
        }
        return res==INT_MAX?-1:res;
    }
};