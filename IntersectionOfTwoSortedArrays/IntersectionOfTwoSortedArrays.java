/*
https://www.geeksforgeeks.org/problems/intersection-of-two-sorted-arrays-with-duplicate-elements/1
*/

class Solution {
    ArrayList<Integer> intersection(int[] a, int[] b) {
        HashMap<Integer, Integer>valuesCountInAMap=new HashMap<>();
        HashMap<Integer, Integer>valuesCountInBMap=new HashMap<>();
        for(int val: a){
            if(valuesCountInAMap.containsKey(val)){
                int currentCount=valuesCountInAMap.get(val);
                valuesCountInAMap.put(val, currentCount+1);
            } else valuesCountInAMap.put(val, 1);
        }
        for(int val: b){
            if(valuesCountInBMap.containsKey(val)){
                int currentCount=valuesCountInBMap.get(val);
                valuesCountInBMap.put(val, currentCount+1);
            } else valuesCountInBMap.put(val, 1);
        }
        ArrayList<Integer>resultantList=new ArrayList<>();
        for(Map.Entry<Integer, Integer>entry: valuesCountInAMap.entrySet()){
            int currentVal=entry.getKey();
            if(valuesCountInBMap.containsKey(currentVal)){
                resultantList.add(currentVal);
            }
        }
        Collections.sort(resultantList);
        return resultantList;
    }
}