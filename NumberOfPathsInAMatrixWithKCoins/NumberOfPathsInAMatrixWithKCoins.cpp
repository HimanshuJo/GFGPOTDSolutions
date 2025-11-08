/*
https://www.geeksforgeeks.org/problems/number-of-paths-in-a-matrix-with-k-coins2728/1
*/

class Solution {
  public:
  
    int dfs(vector<vector<int>>&mat, int k, int rw, int col, int curSm, vector<vector<vector<int>>>&memo){
        if(rw<0||col<0||curSm>k) return 0;
        if(rw==0&&col==0){
            curSm+=mat[rw][col];
            if(curSm==k) return 1;
            return 0;
        }
        if(memo[rw][col][curSm]!=-1) return memo[rw][col][curSm];
        int up=dfs(mat, k, rw-1, col, curSm+mat[rw][col], memo);
        int left=dfs(mat, k, rw, col-1, curSm+mat[rw][col], memo);
        return memo[rw][col][curSm]=up+left;
    }
  
    int numberOfPath(vector<vector<int>>& mat, int k) {
        int rws=mat.size(), cols=mat[0].size(), curSm=0;
        vector<vector<vector<int>>>memo(rws, vector<vector<int>>(cols, vector<int>(k+1, -1)));
        return dfs(mat, k, rws-1, cols-1, curSm, memo);
    }
};