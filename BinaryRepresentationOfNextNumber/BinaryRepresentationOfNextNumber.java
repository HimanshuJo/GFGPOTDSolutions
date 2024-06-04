/*
https://www.geeksforgeeks.org/problems/binary-representation-of-next-number3648/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.binaryNextNumber(s));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String binaryNextNumber(String s) {
        StringBuilder sAfterRemovingPrefixZeros=new StringBuilder();
        int lengthOfS=s.length(), initialIndexInS=0;
        while(s.charAt(initialIndexInS)=='0'){
            initialIndexInS++;
            if(initialIndexInS>=lengthOfS){
                return "1";
            }
        }
        for(int index=initialIndexInS; index<lengthOfS; ++index){
            sAfterRemovingPrefixZeros.append(s.charAt(index));
        }
        int lengthOfSAfterRemovingPrefixZeros=sAfterRemovingPrefixZeros.length();
        for(int index=lengthOfSAfterRemovingPrefixZeros-1; index>=0; --index){
            if(sAfterRemovingPrefixZeros.charAt(index)=='0'){
                sAfterRemovingPrefixZeros.setCharAt(index, '1');
                return String.valueOf(sAfterRemovingPrefixZeros);
            } else{
                sAfterRemovingPrefixZeros.setCharAt(index, '0');
            }
        }
        sAfterRemovingPrefixZeros.insert(0, '1');
        return String.valueOf(sAfterRemovingPrefixZeros);
    }
}