/*
https://www.geeksforgeeks.org/problems/bus-conductor--170647/1
*/

class Solution {
    public int findMoves(int[] chairs, int[] passengers) {
        Arrays.sort(chairs);
        Arrays.sort(passengers);
        int finalLength=chairs.length, resultantMoves=0;
        for(int i=0; i<finalLength; ++i){
            resultantMoves+=Math.abs(chairs[i]-passengers[i]);
        }
        return resultantMoves;
    }
}
