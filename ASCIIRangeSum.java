/*
https://www.geeksforgeeks.org/problems/ascii-range-sum/1
*/

class Solution {
    
    public int ascii(char ch){
        return (int)ch;
    }
    
    public ArrayList<Integer> asciirange(String s) {
        HashMap<Character, Integer>charCountsMap=new HashMap<>();
        TreeMap<Character, ArrayList<Integer>>charIndicesMap=new TreeMap<>();
        int lengthOfS=s.length();
        for(int i=0; i<lengthOfS; ++i){
            char currentChar=s.charAt(i);
            if(charCountsMap.containsKey(currentChar)){
                charCountsMap.put(currentChar, charCountsMap.get(currentChar)+1);
            } else charCountsMap.put(currentChar, 1);
            if(charIndicesMap.containsKey(currentChar)){
                ArrayList<Integer>currentList=charIndicesMap.get(currentChar);
                currentList.add(i);
                charIndicesMap.put(currentChar, currentList);
            } else{
                ArrayList<Integer>currentList=new ArrayList<>();
                currentList.add(i);
                charIndicesMap.put(currentChar, currentList);
            }
        }
        ArrayList<Integer>resultantList=new ArrayList<>();
        for(Map.Entry<Character, Integer>entry: charCountsMap.entrySet()){
            if(entry.getValue()>=2){
                ArrayList<Integer>currentList=charIndicesMap.get(entry.getKey());
                int firstPos=currentList.get(0), lastPos=currentList.get(currentList.size()-1), currentASCIISm=0;
                for(int i=firstPos+1; i<lastPos; ++i){
                    currentASCIISm+=ascii(s.charAt(i));
                }
                if(currentASCIISm>0){
                    resultantList.add(currentASCIISm);
                }
            }
        }
        return resultantList;
    }
}
