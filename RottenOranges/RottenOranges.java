/*
https://www.geeksforgeeks.org/problems/rotten-oranges2536/1
*/

class Pair{
    
    public int first;
    
    public int second;
    
    Pair(int first, int second){
        this.first=first;
        this.second=second;
    }
}


class Solution {
    
    boolean isValid(int[][] mat, Set<Pair>seenIndices, int rowToCheck, int colToCheck){
        int rows=mat.length, columns=mat[0].length;
        if(rowToCheck>=0&&rowToCheck<=rows-1&&colToCheck>=0&&colToCheck<=columns-1){
            if(mat[rowToCheck][colToCheck]!=1) return false;
            Pair tocheckPair=new Pair(rowToCheck, colToCheck);
            if(!seenIndices.contains(tocheckPair)) return true;
        }
        return false;
    }
    
    public int orangesRot(int[][] mat) {
        int rows=mat.length, columns=mat[0].length;
        Set<Pair>seenIndices=new HashSet<>();
        LinkedList<Pair>queue=new LinkedList<>();
        for(int i=0; i<rows; ++i){
            for(int j=0; j<columns; ++j){
                if(mat[i][j]==2){
                    queue.add(new Pair(i, j));
                }
            }
        }
        int[][] dirs=new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int resultantMinTime=0;
        while(!queue.isEmpty()){
            int currentSize=queue.size();
            boolean isAnyValidIndexFound=false;
            while(currentSize-- >0){
                Pair currentPair=queue.pollFirst();
                int currentRow=currentPair.first, currentColumn=currentPair.second;
                for(int[] dir: dirs){
                    int nextRow=currentRow+dir[0], nextColumn=currentColumn+dir[1];
                    if(isValid(mat, seenIndices, nextRow, nextColumn)){
                        isAnyValidIndexFound=true;
                        queue.add(new Pair(nextRow, nextColumn));
                        seenIndices.add(new Pair(nextRow, nextColumn));
                        mat[nextRow][nextColumn]=2;
                    }
                }
            }
            if(isAnyValidIndexFound) resultantMinTime++;
        }
        for(int i=0; i<rows; ++i){
            for(int j=0; j<columns; ++j){
                if(mat[i][j]==1) return -1;
            }
        }
        return resultantMinTime;
    }
}