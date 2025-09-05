/*
https://www.geeksforgeeks.org/problems/2-d-difference-array/1
*/

class Solution {
    public ArrayList<ArrayList<Integer>> applyDiff2D(int[][] mat, int[][] opr) {
        int rows=mat.length, cols=mat[0].length;
        int[][]diffMatrix=new int[rows+1][cols+1];
        for(int i=0; i<=rows; ++i){
            for(int j=0; j<=cols; ++j){
                diffMatrix[i][j]=0;
            }
        }
        int lengthOpr=opr.length;
        for(int i=0; i<lengthOpr; ++i){
            int[] currentOpr=opr[i];
            int valToAdd=currentOpr[0], topLeftRow=currentOpr[1], topLeftCol=currentOpr[2], bottomRightRow=currentOpr[3], bottomRightCol=currentOpr[4];
            diffMatrix[topLeftRow][topLeftCol]+=valToAdd;
            diffMatrix[topLeftRow][bottomRightCol+1]-=valToAdd;
            diffMatrix[bottomRightRow+1][topLeftCol]-=valToAdd;
            diffMatrix[bottomRightRow+1][bottomRightCol+1]+=valToAdd;
        }
        for(int i=0; i<rows; ++i){
            for(int j=1; j<cols; ++j){
                diffMatrix[i][j]+=diffMatrix[i][j-1];
            }
        }
        for(int j=0; j<cols; ++j){
            for(int i=1; i<rows; ++i){
                diffMatrix[i][j]+=diffMatrix[i-1][j];
            }
        }
        for(int i=0; i<rows; ++i){
            for(int j=0; j<cols; ++j){
                mat[i][j]+=diffMatrix[i][j];
            }
        }
        ArrayList<ArrayList<Integer>>resultantMatrix=new ArrayList<>();
        for(int i=0; i<rows; ++i){
            resultantMatrix.add(new ArrayList<>());
            for(int j=0; j<cols; ++j){
                resultantMatrix.get(i).add(mat[i][j]);
            }
        }
        return resultantMatrix;
    }
}
