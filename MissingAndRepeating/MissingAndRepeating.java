/*
https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
*/

class Solution {
    ArrayList<Integer> findTwoElement(int arr[]) {
        HashMap<Integer, Integer>numbersCountMap=new HashMap<>();
        for(int num: arr){
            if(numbersCountMap.containsKey(num)){
                int curCount=numbersCountMap.get(num);
                numbersCountMap.put(num, curCount+1);
            } else numbersCountMap.put(num, 1);
        }
        int lengthOfArr=arr.length;
        int duplicate=-1, missingNumber=-1;
        for(int i=1; i<=lengthOfArr; ++i){
            if(numbersCountMap.containsKey(i)){
                int countToCheck=numbersCountMap.get(i);
                if(countToCheck>1){
                    duplicate=i;
                }
            } else{
                missingNumber=i;
            }
        }
        ArrayList<Integer>resultantList=new ArrayList<>();
        resultantList.add(duplicate);
        resultantList.add(missingNumber);
        return resultantList;
    }
}
