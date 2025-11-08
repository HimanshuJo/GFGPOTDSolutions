/*
https://www.geeksforgeeks.org/problems/number-of-paths-in-a-matrix-with-k-coins2728/1
*/

class Solution {
    
    public int depthFirstSearch_forArrays(int[][]mat, int k, int row, int column, int currentSum, int[][][]memoization){
        if(row<0||column<0||currentSum>k) return 0;
        if(row==0&&column==0){
            currentSum+=mat[row][column];
            if(currentSum==k) return 1;
            return 0;
        }
        if(memoization[row][column][currentSum]!=-1) return memoization[row][column][currentSum];
        int up=depthFirstSearch_forArrays(mat, k, row-1, column, currentSum+mat[row][column], memoization);
        int left=depthFirstSearch_forArrays(mat, k, row, column-1, currentSum+mat[row][column], memoization);
        return memoization[row][column][currentSum]=up+left;
    }
    
    public int numberOfPath(int[][] mat, int k) {
        int rows=mat.length, columns=mat[0].length, currentSum=0;
        int[][][] memoization=new int[rows+1][columns+1][k+1];
        for(int i=0; i<=rows; ++i){
            for(int j=0; j<=columns; ++j){
                for(int l=0; l<=k; ++l){
                    memoization[i][j][l]=-1;
                }
            }
        }
        return depthFirstSearch_forArrays(mat, k, rows-1, columns-1, currentSum, memoization);
    }
}