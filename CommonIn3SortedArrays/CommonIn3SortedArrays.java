/*
https://www.geeksforgeeks.org/problems/common-elements1132/1
*/

class Solution {
    public ArrayList<Integer> commonElements(int[] a, int[] b, int[] c) {
        HashMap<Integer, Integer>mapForA=new HashMap<>();
        HashMap<Integer, Integer>mapForB=new HashMap<>();
        for(int val: a){
            if(mapForA.containsKey(val)){
                int currentCount=mapForA.get(val);
                mapForA.put(val, currentCount+1);
            } else{
                mapForA.put(val, 1);
            }
        }
        for(int val: b){
            if(mapForB.containsKey(val)){
                int currentCount=mapForB.get(val);
                mapForB.put(val, currentCount+1);
            } else{
                mapForB.put(val, 1);
            }
        }
        HashSet<Integer>uniqueVals=new HashSet<>();
        for(int val: c){
            uniqueVals.add(val);
        }
        ArrayList<Integer>resultantList=new ArrayList<>();
        Iterator itr=uniqueVals.iterator();
        while(itr.hasNext()){
            int currentVal=(int)itr.next();
            boolean containsInA=mapForA.containsKey(currentVal);
            boolean containsInB=mapForB.containsKey(currentVal);
            if(containsInA!=false&&containsInB!=false){
                resultantList.add(currentVal);
            }
        }
        Collections.sort(resultantList);
        return resultantList;
    }
}