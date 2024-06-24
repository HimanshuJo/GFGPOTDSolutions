/*
https://www.geeksforgeeks.org/problems/compare-two-fractions4438/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        StringBuilder firstNumberInStrAsString=new StringBuilder();
        StringBuilder secondNumberInStrAsString=new StringBuilder();
        StringBuilder thirdNumberInStrAsString=new StringBuilder();
        StringBuilder fourthNumberInStrAsString=new StringBuilder();
        int lengthOfStr=str.length(), initialTraversalIndex=0;
        while(initialTraversalIndex<=lengthOfStr-1){
            if(str.charAt(initialTraversalIndex)=='/') break;
            firstNumberInStrAsString.append(str.charAt(initialTraversalIndex));
            initialTraversalIndex++;
        }
        initialTraversalIndex++;
        while(initialTraversalIndex<=lengthOfStr-1){
            if(str.charAt(initialTraversalIndex)==',') break;
            secondNumberInStrAsString.append(str.charAt(initialTraversalIndex));
            initialTraversalIndex++;
        }
        initialTraversalIndex++;
        initialTraversalIndex++;
        while(initialTraversalIndex<=lengthOfStr-1){
            if(str.charAt(initialTraversalIndex)=='/') break;
            thirdNumberInStrAsString.append(str.charAt(initialTraversalIndex));
            initialTraversalIndex++;
        }
        initialTraversalIndex++;
        while(initialTraversalIndex<=lengthOfStr-1){
            if(str.charAt(initialTraversalIndex)==',') break;
            fourthNumberInStrAsString.append(str.charAt(initialTraversalIndex));
            initialTraversalIndex++;
        }
        int firstNumberInStrAsInteger=Integer.parseInt(String.valueOf(firstNumberInStrAsString)),
            secondNumberInStrAsInteger=Integer.parseInt(String.valueOf(secondNumberInStrAsString)),
            thirdNumberInStrAsInteger=Integer.parseInt(String.valueOf(thirdNumberInStrAsString)),
            fourthNumberInStrAsInteger=Integer.parseInt(String.valueOf(fourthNumberInStrAsString));
        double firstFraction=(double)firstNumberInStrAsInteger/secondNumberInStrAsInteger,
               secondFraction=(double)thirdNumberInStrAsInteger/fourthNumberInStrAsInteger;
        if(firstFraction==secondFraction) return "equal";
        else if(firstFraction>secondFraction) return firstNumberInStrAsString+"/"+secondNumberInStrAsString;
        return thirdNumberInStrAsString+"/"+fourthNumberInStrAsString;
    }
}
