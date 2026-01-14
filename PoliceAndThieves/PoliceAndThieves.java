/*
https://www.geeksforgeeks.org/problems/police-and-thieves--141631/1
*/

class Solution {
    public int catchThieves(char[] arr, int k) {
        ArrayList<Integer>policeIndices=new ArrayList<>();
        ArrayList<Integer>thiefIndices=new ArrayList<>();
        for(int i=0; i<arr.length; ++i){
            if(arr[i]=='P') policeIndices.add(i);
            else thiefIndices.add(i);
        }
        int indexForPolice=0, indexForThief=0, resultantMaxThieves=0;
        while(indexForPolice<policeIndices.size()&&indexForThief<thiefIndices.size()){
            if(Math.abs(policeIndices.get(indexForPolice)-thiefIndices.get(indexForThief))<=k){
                indexForPolice++;
                indexForThief++;
                resultantMaxThieves++;
            } else if(thiefIndices.get(indexForThief)<policeIndices.get(indexForPolice)){
                indexForThief++;
            } else indexForPolice++;
        }
        return resultantMaxThieves;
    }
}