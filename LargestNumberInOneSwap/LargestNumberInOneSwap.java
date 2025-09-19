/*
https://www.geeksforgeeks.org/problems/largest-number-in-one-swap1520/1
*/

class Pair {
    public char first;
    public int second;
    public Pair(char first, int second){
        this.first = first;
        this.second = second;
    }
}

class CustomComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair A, Pair B) {
        if (A.first == B.first) {
            return Integer.compare(B.second, A.second);
        }

        return Character.compare(B.first, A.first);
    }
}

class Solution {
    public String largestSwap(String s) {
        int lengthOfS = s.length();
        ArrayList<Pair> sCharIndexComb = new ArrayList<>();
        
        for (int i = 0; i < lengthOfS; ++i) {
            sCharIndexComb.add(new Pair(s.charAt(i), i));
        }
        
        Collections.sort(sCharIndexComb, new CustomComparator());
        
        int index1 = 0, index2 = 0;
        HashSet<Integer> seenIndexes = new HashSet<>();
        StringBuilder resultantString = new StringBuilder(s);
        
        while (index1 < lengthOfS && index2 < sCharIndexComb.size()) {
            
            while (index2 < sCharIndexComb.size() && seenIndexes.contains(sCharIndexComb.get(index2).second)) {
                index2++;
            }
            if (index2 >= sCharIndexComb.size()) break;
            
            char charToCheck = sCharIndexComb.get(index2).first;
            int indexToCheck = sCharIndexComb.get(index2).second;
            
            if (s.charAt(index1) == charToCheck) {
                if (index1 == indexToCheck) {
                    seenIndexes.add(index1);
                    index1++;
                    index2++;
                } else {
                    seenIndexes.add(index1);
                    index1++;
                }
            } else {
                char charToReplace = s.charAt(index1);
                resultantString.setCharAt(index1, charToCheck);
                resultantString.setCharAt(indexToCheck, charToReplace);
                break;
            }
        }
        
        return resultantString.toString();
    }
}
