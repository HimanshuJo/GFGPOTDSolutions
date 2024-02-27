/*
https://www.geeksforgeeks.org/problems/check-if-a-number-is-divisible-by-83957/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int DivisibleByEight(String s){
        int sz=s.length();
        StringBuilder sbf=new StringBuilder();
        if((s.charAt(sz-1)-'0')%2!=0) return -1;
        if(sz<=3){
            if(Integer.parseInt(String.valueOf(s))%8!=0) return -1;
            return 1;
        }
        sbf.append(s.charAt(sz-3));
        sbf.append(s.charAt(sz-2));
        sbf.append(s.charAt(sz-1));
        if(Integer.parseInt(String.valueOf(sbf))%8==0) return 1;
        return -1;
    }
}