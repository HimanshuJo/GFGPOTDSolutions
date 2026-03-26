/*
https://www.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1
*/

class Solution_TLE {
  public:
  
    int bfs(vector<vector<pair<int, int>>>&gr, int V){
        queue<pair<vector<int>, int>>q;
        vector<int>bgn{0};
        q.push({bgn, 0});
        map<int, int>mp;
        while(!q.empty()){
            int sz=q.size();
            while(sz--){
                auto currvecpair=q.front();
                q.pop();
                vector<int>currvec=currvecpair.first;
                int currcost=currvecpair.second, currback=currvec.back();
                if(currback==V-1){
                    mp[currcost]++;
                } else{
                    for(auto &nei: gr[currback]){
                        auto itr=find(currvec.begin(), currvec.end(), nei.first);
                        if(itr==currvec.end()){
                            auto currcpy=currvec;
                            int currcostcpy=currcost;
                            currcpy.push_back(nei.first);
                            currcostcpy+=nei.second;
                            q.push({currcpy, currcostcpy});
                        }
                    }   
                }
            }
        }
        auto itr=mp.begin();
        return itr->second;
    }
  
    int countPaths(int V, vector<vector<int>>& edges) {
        vector<vector<pair<int, int>>>gr(V);
        for(auto &edge: edges){
            gr[edge[0]].push_back({edge[1], edge[2]});
            gr[edge[1]].push_back({edge[0], edge[2]});
        }
        return bfs(gr, V);
    }
};

// ------- ******* -------

class Solution {
public:
    int countPaths(int V, vector<vector<int>>& edges) {

        const int MOD = 1e9 + 7;

        vector<vector<pair<int,int>>> gr(V);

        for(auto &e : edges){
            gr[e[0]].push_back({e[1], e[2]});
            gr[e[1]].push_back({e[0], e[2]});
        }

        vector<long long> dist(V, LLONG_MAX);
        vector<long long> ways(V, 0);

        priority_queue<pair<long long,int>, vector<pair<long long,int>>, greater<>> pq;

        dist[0] = 0;
        ways[0] = 1;

        pq.push({0, 0});

        while(!pq.empty()){
            auto [d, node] = pq.top();
            pq.pop();

            if(d > dist[node]) continue;

            for(auto &nei : gr[node]){
                int next = nei.first;
                long long newDist = d + nei.second;

                if(newDist < dist[next]){
                    dist[next] = newDist;
                    ways[next] = ways[node];
                    pq.push({newDist, next});
                }
                else if(newDist == dist[next]){
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return ways[V - 1] % MOD;
    }
};