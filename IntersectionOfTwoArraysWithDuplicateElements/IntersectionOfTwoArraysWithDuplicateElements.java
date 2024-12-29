/*
https://www.geeksforgeeks.org/problems/intersection-of-two-arrays-with-duplicate-elements/1
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // First array input
            String[] str1 = br.readLine().trim().split(
                " "); // Read the first line and split by spaces
            int n = str1.length;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str1[i]); // Convert each element to an integer
            }

            // Second array input
            String[] str2 = br.readLine().trim().split(
                " "); // Read the second line and split by spaces
            int m = str2.length;
            int[] b = new int[m];
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(str2[i]); // Convert each element to an integer
            }

            Solution sol = new Solution();
            ArrayList<Integer> res = sol.intersectionWithDuplicates(a, b);

            // Sort the result
            Collections.sort(res);

            // Print the result
            if (res.isEmpty()) {
                System.out.println("[]");
            } else {
                for (int num : res) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        ArrayList<Integer>resultantList=new ArrayList<>();
        HashMap<Integer, Integer>integerCountMapping=new HashMap<>();
        HashSet<Integer>seenValues=new HashSet<>();
        for(int values: a){
            if(integerCountMapping.containsKey(values)){
                integerCountMapping.put(values, integerCountMapping.get(values)+1);
            } else integerCountMapping.put(values, 1);
        }
        for(int values: b){
            if(!seenValues.contains(values)){
                if(integerCountMapping.containsKey(values)){
                    resultantList.add(values);
                    seenValues.add(values);
                }
            }
        }
        return resultantList;
    }
}