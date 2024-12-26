/*
https://www.geeksforgeeks.org/problems/key-pair5616/1
*/

/*
// User function Template for Java

class Solution {
    boolean twoSum(int arr[], int target) {
        TreeMap<Integer, ArrayList<Integer>>valueIndicesMap=new TreeMap<>();
        int lengthOfArr=arr.length;
        for(int i=0; i<lengthOfArr; ++i){
            if(valueIndicesMap.containsKey(arr[i])){
                ArrayList<Integer>currentList=valueIndicesMap.get(arr[i]);
                currentList.add(i);
                valueIndicesMap.put(arr[i], currentList);
            } else{
                ArrayList<Integer>currentList=new ArrayList<>();
                currentList.add(i);
                valueIndicesMap.put(arr[i], currentList);
            }
        }
        for(int i=0; i<lengthOfArr; ++i){
            int requiredNumber=target-arr[i];
            if(valueIndicesMap.containsKey(requiredNumber)){
                ArrayList<Integer>listToCheck=valueIndicesMap.get(requiredNumber);
                if(listToCheck.size()==1) return listToCheck.get(0)!=i;
                return true;
            }
        }
        return false;
    }
}
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            // int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[0]);

            String line = br.readLine();
            String[] tokens = line.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            boolean ans = new Solution().twoSum(arr, x);
            System.out.println(ans ? "true" : "false");
            // System.out.println("~");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    boolean twoSum(int arr[], int target) {
        HashMap<Integer, Integer>valueIndexMap=new HashMap<>();
        int lengthOfArr=arr.length;
        for(int i=0; i<lengthOfArr; ++i){
            valueIndexMap.put(arr[i], i);
        }
        for(int i=0; i<lengthOfArr; ++i){
            int requiredNumber=target-arr[i];
            if(valueIndexMap.containsKey(requiredNumber)&&valueIndexMap.get(requiredNumber)!=i) return true;
        }
        return false;
    }
}