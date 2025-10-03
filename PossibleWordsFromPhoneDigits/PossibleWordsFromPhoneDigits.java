/*
https://www.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1
*/

class Solution {
    
    private ArrayList<String> resultantListOfAllWords;

    public Solution() {
        this.resultantListOfAllWords = new ArrayList<>();
    }

    public ArrayList<String> getResultantListOfAllWords() {
        return resultantListOfAllWords;
    }

    public void setResultantListOfAllWords(ArrayList<String> newList) {
        this.resultantListOfAllWords = newList;
    }

    public void depthFirstSearch_forArrays(int[] arr, HashMap<Integer, String> numbersToStringMap, 
                                           int lengthOfArr, StringBuilder currentString,  
                                           int currentIndex) {
        if (currentIndex >= lengthOfArr) {
            resultantListOfAllWords.add(currentString.toString());
            return;
        }

        int currentDigit = arr[currentIndex];

        if (currentDigit == 0 || currentDigit == 1) {
            depthFirstSearch_forArrays(arr, numbersToStringMap, lengthOfArr, currentString, currentIndex + 1);
            return;
        }

        String currentMappingString = numbersToStringMap.get(currentDigit);
        for (int i = 0; i < currentMappingString.length(); ++i) {
            currentString.append(currentMappingString.charAt(i));
            depthFirstSearch_forArrays(arr, numbersToStringMap, lengthOfArr, currentString, currentIndex + 1);
            currentString.deleteCharAt(currentString.length() - 1); // backtrack
        }
    }
    
    public ArrayList<String> possibleWords(int[] arr) {
        HashMap<Integer, String> numbersToStringMap = new HashMap<>();
        numbersToStringMap.put(2, "abc");
        numbersToStringMap.put(3, "def");
        numbersToStringMap.put(4, "ghi");
        numbersToStringMap.put(5, "jkl");
        numbersToStringMap.put(6, "mno");
        numbersToStringMap.put(7, "pqrs");
        numbersToStringMap.put(8, "tuv");
        numbersToStringMap.put(9, "wxyz");
        
        int lengthOfArr = arr.length;
        StringBuilder currentString = new StringBuilder();

        setResultantListOfAllWords(new ArrayList<>());

        depthFirstSearch_forArrays(arr, numbersToStringMap, lengthOfArr, currentString, 0);

        return getResultantListOfAllWords();
    }
}
