/*
https://www.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        int sizeOfArr=arr.size();
        ArrayList<Integer>positiveNumbers=new ArrayList<>();
        ArrayList<Integer>negativeNumbers=new ArrayList<>();
        for(int i=0; i<sizeOfArr; ++i){
            if(arr.get(i)>=0){
                positiveNumbers.add(arr.get(i));
            } else{
                negativeNumbers.add(arr.get(i));
            }
        }
        int beginIndexForPositives=0, beginIndexForNegatives=0;
        for(int i=0; i<sizeOfArr; ++i){
            if(i%2==0){
                if(positiveNumbers.size()>=1&&beginIndexForPositives<=positiveNumbers.size()-1){
                    arr.set(i, positiveNumbers.get(beginIndexForPositives++));
                } else{
                    arr.set(i, negativeNumbers.get(beginIndexForNegatives++));
                }
            } else{
                if(negativeNumbers.size()>=1&&beginIndexForNegatives<=negativeNumbers.size()-1){
                    arr.set(i, negativeNumbers.get(beginIndexForNegatives++));
                } else{
                    arr.set(i, positiveNumbers.get(beginIndexForPositives++));
                }
            }
        }
    }
}