/*
https://www.geeksforgeeks.org/problems/longest-common-prefix-in-an-array5129/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        Arrays.sort(arr);
        int lengthOfArr=arr.length;
        String shortestString=arr[0];
        int lengthOfShortestString=shortestString.length();
        String resultantCommonPrefix=new String();
        for(int i=0; i<lengthOfShortestString; ++i){
            char currentCharacter=shortestString.charAt(i);
            boolean isCurrentCharacterAvailableInRestStrings=true;
            for(int j=1; j<lengthOfArr; ++j){
                if(arr[j].charAt(i)!=currentCharacter){
                    isCurrentCharacterAvailableInRestStrings=false;
                    break;
                }
            }
            if(isCurrentCharacterAvailableInRestStrings){
                resultantCommonPrefix+=currentCharacter;
            } else break;
        }
        return resultantCommonPrefix.length()==0?"-1":resultantCommonPrefix;
    }
}