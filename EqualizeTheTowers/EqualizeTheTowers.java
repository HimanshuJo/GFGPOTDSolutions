/*
https://www.geeksforgeeks.org/problems/equalize-the-towers2804/1
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
    public int minCost(int[] heights, int[] cost) {
        ArrayList<Pair>heightCostPair=new ArrayList<>();
        int length=heights.length;
        for(int i=0; i<length; ++i){
            heightCostPair.add(new Pair(heights[i], cost[i]));
        }
        Collections.sort(heightCostPair, (A, B)->A.first-B.first);
        long totalWeight=0;
        for(int i=0; i<length; ++i){
            totalWeight+=heightCostPair.get(i).second;
        }
        long medianHeight=0, cumulativeWeight=0;
        for(int i=0; i<length; ++i){
            cumulativeWeight+=heightCostPair.get(i).second;
            if(2*cumulativeWeight>=totalWeight){
                medianHeight=heightCostPair.get(i).first;
                break;
            }
        }
        int res=0;
        for(int i=0; i<length; ++i){
            res+=Math.abs(heights[i]-medianHeight)*cost[i];
        }
        return res;
    }
}
