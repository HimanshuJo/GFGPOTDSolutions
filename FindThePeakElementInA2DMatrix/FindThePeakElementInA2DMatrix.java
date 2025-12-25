/*
https://www.geeksforgeeks.org/problems/find-the-peak-element-in-a-2d-matrix/1
*/

class Solution {
    
    public boolean isValidIndexPair(int[][] mat, int currentRow, int currentColumn){
        int rows=mat.length, columns=mat[0].length, currentValue=mat[currentRow][currentColumn];
        if(currentRow-1>=0) if(mat[currentRow-1][currentColumn]>currentValue) return false;
        if(currentRow+1<=rows-1) if(mat[currentRow+1][currentColumn]>currentValue) return false;
        if(currentColumn-1>=0) if(mat[currentRow][currentColumn-1]>currentValue) return false;
        if(currentColumn+1<=columns-1) if(mat[currentRow][currentColumn+1]>currentValue) return false;
        return true;
    }
    
    public ArrayList<Integer> findPeakGrid(int[][] mat) {
        int rows=mat.length, columns=mat[0].length;
        ArrayList<Integer>resultantIndexPair=new ArrayList<>();
        for(int i=0; i<rows; ++i){
            for(int j=0; j<columns; ++j){
                if(isValidIndexPair(mat, i, j)){
                    resultantIndexPair.add(i);
                    resultantIndexPair.add(j);
                    return resultantIndexPair;
                }
            }
        }
        return resultantIndexPair;
    }
}