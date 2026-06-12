/*
https://www.geeksforgeeks.org/problems/check-if-a-string-is-repetition-of-its-substring-of-k-length3302/1
*/

class Pair{
    
    public int first;
    
    public ArrayList<Integer> second;
    
    Pair(int first, ArrayList<Integer>second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public boolean kSubstr(String s, int k) {
        HashMap<String, Pair>substringCountMap=new HashMap<>();
        int lengthOfS=s.length(), currentIndex=0;
        if(lengthOfS%k!=0) return false;
        while(currentIndex<=lengthOfS-1){
            int beginIndex=currentIndex;
            StringBuilder currentString=new StringBuilder();
            while(true){
                currentString.append(s.charAt(currentIndex++));
                if(currentString.length()==k) break;
            }
            if(substringCountMap.containsKey(String.valueOf(currentString))){
                Pair currentPair=substringCountMap.get(String.valueOf(currentString));
                int currentSubstringsCount=currentPair.first;
                ArrayList<Integer>currentIndices=currentPair.second;
                currentSubstringsCount++;
                currentIndices.add(beginIndex);
                Pair updatedPair=new Pair(currentSubstringsCount, currentIndices);
                substringCountMap.put(String.valueOf(currentString), updatedPair);
            } else{
                int currentSubstringsCount=1;
                ArrayList<Integer>currentIndices=new ArrayList<>();
                currentIndices.add(beginIndex);
                Pair toBeAdded=new Pair(currentSubstringsCount, currentIndices);
                substringCountMap.put(String.valueOf(currentString), toBeAdded);
            }
        }
        if(substringCountMap.size()==1) return true;
        if(substringCountMap.size()>2) return false;
        for(Map.Entry<String, Pair>entries: substringCountMap.entrySet()){
            Pair currentValue=entries.getValue();
            if(currentValue.first==1){
                if((currentValue.second).get(0)%k==0) return true;
            }
        }
        return false;
    }
}