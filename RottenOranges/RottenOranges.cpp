/*
https://www.geeksforgeeks.org/problems/rotten-oranges2536/1
*/

class Solution {
  public:
  
    bool isValid(vector<vector<int>>&mat, set<pair<int, int>>&seen, int rowToCheck, int colToCheck){
        int rows=mat.size(), cols=mat[0].size();
        if(rowToCheck>=0&&rowToCheck<=rows-1&&colToCheck>=0&&colToCheck<=cols-1){
            if(mat[rowToCheck][colToCheck]!=1) return false;
            auto itr=seen.find({rowToCheck, colToCheck});
            if(itr==seen.end()){
                return true;
            }
        }
        return false;
    }
  
    int bfs(vector<vector<int>>&mat){
        int rows=mat.size(), cols=mat[0].size();
        set<pair<int, int>>seen;
        queue<pair<int, int>>q;
        for(int i=0; i<rows; ++i){
            for(int j=0; j<cols; ++j){
                if(mat[i][j]==2){
                    q.push({i, j});
                }
            }
        }
        vector<vector<int>>dirs{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res=0;
        while(!q.empty()){
            int sz=q.size();
            bool flag=false;
            while(sz--){
                auto currFront=q.front();
                q.pop();
                int currw=currFront.first, curcol=currFront.second;
                for(auto &dir: dirs){
                    int nxtrw=currw+dir[0], nxtcol=curcol+dir[1];
                    if(isValid(mat, seen, nxtrw, nxtcol)){
                        flag=true;
                        q.push({nxtrw, nxtcol});
                        seen.insert({nxtrw, nxtcol});
                        mat[nxtrw][nxtcol]=2;
                    }
                }
            }
            if(flag) res++;
        }
        for(int i=0; i<rows; ++i){
            for(int j=0; j<cols; ++j){
                if(mat[i][j]==1) return -1;
            }
        }
        return res;
    }
  
    int orangesRot(vector<vector<int>>& mat) {
        return bfs(mat);
    }
};