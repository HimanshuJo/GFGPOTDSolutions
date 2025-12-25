/*
https://www.geeksforgeeks.org/problems/find-the-peak-element-in-a-2d-matrix/1
*/

class Solution {
  public:
  
    bool isValid(vector<vector<int>>&mat, int currw, int curcol){
        int rws=mat.size(), cols=mat[0].size(), curVal=mat[currw][curcol];
        if(currw-1>=0) if(mat[currw-1][curcol]>curVal) return false;
        if(currw+1<=rws-1) if(mat[currw+1][curcol]>curVal) return false;
        if(curcol-1>=0) if(mat[currw][curcol-1]>curVal) return false;
        if(curcol+1<=cols-1) if(mat[currw][curcol+1]>curVal) return false;
        return true;
    }
  
    vector<int> findPeakGrid(vector<vector<int>>& mat) {
        int rws=mat.size(), cols=mat[0].size();
        for(int i=0; i<rws; ++i){
            for(int j=0; j<cols; ++j){
                if(isValid(mat, i, j)) return {i, j};
            }
        }
        return {};
    }
};
