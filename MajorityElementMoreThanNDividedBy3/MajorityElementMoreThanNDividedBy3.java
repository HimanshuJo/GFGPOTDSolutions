/*
https://www.geeksforgeeks.org/problems/majority-vote/1
*/

class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int lengthOfArr=arr.length;
        HashMap<Integer, Integer>countMap=new HashMap<>();
        for(int i=0; i<lengthOfArr; ++i){
            if(countMap.containsKey(arr[i])){
                countMap.put(arr[i], countMap.get(arr[i])+1);
            } else countMap.put(arr[i], 1);
        }
        ArrayList<Integer>resultantList=new ArrayList<>();
        for(Map.Entry<Integer, Integer>countMapEntry: countMap.entrySet()){
            if(countMapEntry.getValue()>Math.floor(lengthOfArr)/3){
                resultantList.add(countMapEntry.getKey());
            }
        }
        Collections.sort(resultantList);
        return resultantList;
    }
}
