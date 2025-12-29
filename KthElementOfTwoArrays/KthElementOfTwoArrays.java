/*
https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
*/

class Solution {
    public int kthElement(int a[], int b[], int k) {
        TreeMap<Integer, Integer>valueCountMap=new TreeMap<>();
        for(int value: a){
            if(valueCountMap.containsKey(value)){
                int currentCount=valueCountMap.get(value);
                currentCount+=1;
                valueCountMap.put(value, currentCount);
            } else valueCountMap.put(value, 1);
        }
        for(int value: b){
            if(valueCountMap.containsKey(value)){
                int currentCount=valueCountMap.get(value);
                currentCount+=1;
                valueCountMap.put(value, currentCount);
            } else valueCountMap.put(value, 1);
        }
        ArrayList<Integer>sortedList=new ArrayList<>();
        for(Map.Entry<Integer, Integer>entry: valueCountMap.entrySet()){
            int currentValue=entry.getKey(), currentCount=entry.getValue();
            for(int i=1; i<=currentCount; ++i){
                sortedList.add(currentValue);
            }
        }
        return sortedList.get(k-1);
    }
}