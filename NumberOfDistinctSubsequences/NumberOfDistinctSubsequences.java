/*
https://www.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1
*/

class Solution_TLE {
    
    void depthFirstSearch_forStrings(String str, int lengthOfStr, int currentIndex, 
                                     HashSet<String>allDistinctSubsequences, StringBuilder currentString){
        if(currentIndex==lengthOfStr){
            allDistinctSubsequences.add(String.valueOf(currentString));
            return;
        }
        depthFirstSearch_forStrings(str, lengthOfStr, currentIndex+1, allDistinctSubsequences, currentString);
        StringBuilder sbfToBeAdded=new StringBuilder(currentString);
        sbfToBeAdded.append(str.charAt(currentIndex));
        depthFirstSearch_forStrings(str, lengthOfStr, currentIndex+1, allDistinctSubsequences, sbfToBeAdded);
        return;
    }
    
    int distinctSubseq(String str) {
        int lengthOfStr=str.length(), beginIndex=0;
        HashSet<String>allDistinctSubsequences=new HashSet<>();
        StringBuilder currentString=new StringBuilder();
        depthFirstSearch_forStrings(str, lengthOfStr, beginIndex, allDistinctSubsequences, currentString);
        return (int)allDistinctSubsequences.size();
    }
}

// ------- ******* -------

