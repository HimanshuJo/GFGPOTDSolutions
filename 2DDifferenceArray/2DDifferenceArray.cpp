/*
https://www.geeksforgeeks.org/problems/2-d-difference-array/1
*/

class Solution {
  public:
    vector<vector<int>> applyDiff2D(vector<vector<int>>& mat,
                                    vector<vector<int>>& opr) {
        int rws=mat.size(), cols=mat[0].size(), oprsz=opr.size();
        vector<vector<int>>diffMat(rws, vector<int>(cols, 0));
        for(int i=0; i<oprsz; ++i){
            vector<int>curopr=opr[i];
            int curvaltoad=curopr[0], r1=curopr[1], c1=curopr[2], r2=curopr[3], c2=curopr[4];
            diffMat[r1][c1]+=curvaltoad;
            if(c2+1<=cols-1)
                diffMat[r1][c2+1]-=curvaltoad;
            if(r2+1<=rws-1)
                diffMat[r2+1][c1]-=curvaltoad;
            if(r2+1<=rws-1&&c2+1<=cols-1)
                diffMat[r2+1][c2+1]+=curvaltoad;
        }
        for(int i=0; i<rws; ++i){
            for(int j=1; j<cols; ++j){
                diffMat[i][j]+=diffMat[i][j-1];
            }
        }
        for(int j=0; j<cols; ++j){
            for(int i=1; i<rws; ++i){
                diffMat[i][j]+=diffMat[i-1][j];
            }
        }
        for(int i=0; i<rws; ++i){
            for(int j=0; j<cols; ++j){
                mat[i][j]+=diffMat[i][j];
            }
        }
        return mat;
    }
};
