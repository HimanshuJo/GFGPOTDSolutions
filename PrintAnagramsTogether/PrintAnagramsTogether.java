/*
https://www.geeksforgeeks.org/problems/print-anagrams-together/1
*/

//{ Driver Code Starts
import java.util.*;


// } Driver Code Ends
class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        TreeMap<String, ArrayList<Integer>>stringIndicesMapping=new TreeMap<>();
        int lengthOfArr=arr.length;
        for(int i=0; i<lengthOfArr; ++i){
            String currentString=arr[i];
            char[] currentStringArray=currentString.toCharArray();
            Arrays.sort(currentStringArray);
            StringBuilder sortedString=new StringBuilder();
            for(int ii=0; ii<currentStringArray.length; ++ii){
                sortedString.append(currentStringArray[ii]);
            }
            if(stringIndicesMapping.containsKey(String.valueOf(sortedString))){
                ArrayList<Integer>currentIndices=stringIndicesMapping.get(String.valueOf(sortedString));
                currentIndices.add(i);
                stringIndicesMapping.put(String.valueOf(sortedString), currentIndices);
            } else{
                ArrayList<Integer>currentIndices=new ArrayList<>();
                currentIndices.add(i);
                stringIndicesMapping.put(String.valueOf(sortedString), currentIndices);
            }
        }
        ArrayList<ArrayList<String>>resultantIndicesList=new ArrayList<>();
        for(Map.Entry<String, ArrayList<Integer>>entries: stringIndicesMapping.entrySet()){
            ArrayList<String>listToAdd=new ArrayList<>();
            ArrayList<Integer>currentIndices=(ArrayList<Integer>)entries.getValue();
            for(int i=0; i<currentIndices.size(); ++i){
                listToAdd.add(arr[currentIndices.get(i)]);
            }
            resultantIndicesList.add(listToAdd);
        }
        Collections.sort(resultantIndicesList, new Comparator<ArrayList<String>>() {
            @Override
            public int compare(ArrayList<String> list1, ArrayList<String> list2) {
                int size1 = list1.size();
                int size2 = list2.size();
                int minSize = Math.min(size1, size2);

                for (int i = 0; i < minSize; i++) {
                    int cmp = list1.get(i).compareTo(list2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return Integer.compare(size1, size2);
            }
        });
        return resultantIndicesList;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Ignore the newline after the test case input
        while (t-- > 0) {
            String inputLine = sc.nextLine();
            String[] arr = inputLine.split(" ");

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> result = ob.anagrams(arr);
            result.sort(Comparator.comparing(a -> a.get(0)));
            for (ArrayList<String> group : result) {
                for (String word : group) {
                    System.out.print(word + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends