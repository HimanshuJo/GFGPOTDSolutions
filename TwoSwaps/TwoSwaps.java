/*
https://www.geeksforgeeks.org/problems/two-swaps--155623/1
*/

//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {
    
    public void swap(List<Integer>arr, int firstIndex, int secondIndex){
        int tempVar=arr.get(firstIndex);
        arr.set(firstIndex, arr.get(secondIndex));
        arr.set(secondIndex, tempVar);
    }
    
    public int find(List<Integer>arr, int numberToFind){
        int lengthOfArr=arr.size(), resultantIndex=-1;
        for(int i=0; i<lengthOfArr; ++i){
            if(arr.get(i)==numberToFind){
                resultantIndex=i;
                break;
            }
        }
        return resultantIndex;
    }

    public boolean checkSorted(List<Integer> arr) {
        int sizeOfArr=arr.size(), numberOfSwaps=0;
        for(int i=0; i<sizeOfArr; ++i){
            int indexOfCurrentNumber=find(arr, i+1);
            if(indexOfCurrentNumber!=i){
                if(numberOfSwaps==2) return false;
                swap(arr, i, indexOfCurrentNumber);
                numberOfSwaps++;
            }
        }
        return numberOfSwaps==0||numberOfSwaps==2;
    }
}