/*
https://www.geeksforgeeks.org/problems/minimum-cost-to-connect-all-houses-in-a-city/1
*/

class Solution {

    public int minCost(int[][] houses) {
        int numHouses=houses.length, resultantMinCost=0;
        int[] minDistForEachNode=new int[numHouses];
        boolean[] visitedNodes=new boolean[numHouses];
        for(int i=0; i<numHouses; ++i){
            minDistForEachNode[i]=Integer.MAX_VALUE;
            visitedNodes[i]=false;
        }
        minDistForEachNode[0]=0;
        for(int i=0; i<numHouses; ++i){
            int curNonVisNodeWithSubOptimalDist=-1;
            for(int j=0; j<numHouses; ++j){
                if(visitedNodes[j]==false&&
                (curNonVisNodeWithSubOptimalDist==-1||
                (minDistForEachNode[j]<minDistForEachNode[curNonVisNodeWithSubOptimalDist]))){
                    curNonVisNodeWithSubOptimalDist=j;
                }
            }
            visitedNodes[curNonVisNodeWithSubOptimalDist]=true;
            resultantMinCost+=minDistForEachNode[curNonVisNodeWithSubOptimalDist];
            for(int v=0; v<numHouses; ++v){
                if(visitedNodes[v]==false){
                    int curDist=Math.abs(houses[v][0]-houses[curNonVisNodeWithSubOptimalDist][0])+
                    Math.abs(houses[v][1]-houses[curNonVisNodeWithSubOptimalDist][1]);
                    minDistForEachNode[v]=Math.min(minDistForEachNode[v], curDist);
                }
            }
        }
        return resultantMinCost;
    }
}
