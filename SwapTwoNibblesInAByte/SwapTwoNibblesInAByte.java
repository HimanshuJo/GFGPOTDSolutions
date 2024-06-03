/*
https://www.geeksforgeeks.org/problems/swap-two-nibbles-in-a-byte0446/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

/*
TLE: 221 / 1115

// User function Template for Java
class Solution {
    
    static int converBinaryStringToDecimal(String binaryString){
        int lengthOfBinaryString=binaryString.length(), initialPowerOfTwoForTraversal=lengthOfBinaryString-1, binaryStringToDecimal=0;
        for(int index=0; index<lengthOfBinaryString; ++index){
            binaryStringToDecimal+=(binaryString.charAt(index)-'0')*(Math.pow(2, initialPowerOfTwoForTraversal--));
        }
        return binaryStringToDecimal;
    }
    
    static String convertIntegerToBinaryString(int integer){
        StringBuilder integerToBinaryString=new StringBuilder("");
        while(integer!=1){
            int quotientWhenDivisionByTwo=integer/2, remainderWhenDivisionByTwo=integer%2;
            integerToBinaryString.append(String.valueOf(remainderWhenDivisionByTwo));
            integer=quotientWhenDivisionByTwo;
        }
        integerToBinaryString.append("1");
        while(integerToBinaryString.length()!=8){
            integerToBinaryString.append("0");
        }
        integerToBinaryString.reverse();
        return String.valueOf(integerToBinaryString);
    }
    
    static int swapNibbles(int n) {
        String nToBinaryString=convertIntegerToBinaryString(n);
        StringBuilder upperNibble=new StringBuilder("");
        StringBuilder lowerNibble=new StringBuilder("");
        int lengthOfNToBinaryString=nToBinaryString.length();
        for(int index=0; index<lengthOfNToBinaryString/2; ++index){
            upperNibble.append(nToBinaryString.charAt(index));
        }
        for(int index=lengthOfNToBinaryString/2; index<lengthOfNToBinaryString; ++index){
            lowerNibble.append(nToBinaryString.charAt(index));
        }
        String swappedUpperNibbleLowerNibble="";
        swappedUpperNibbleLowerNibble+=(String.valueOf(lowerNibble));
        swappedUpperNibbleLowerNibble+=(String.valueOf(upperNibble));
        int resultingNumberAfterSwappingUpperLowerNibble=converBinaryStringToDecimal(swappedUpperNibbleLowerNibble);
        return resultingNumberAfterSwappingUpperLowerNibble;
    }
}
*/

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int swapNibbles(int n) {
        int lowerNibble=(n&0x0F)<<4, upperNibble=(n&0xF0)>>4;
        return lowerNibble|upperNibble;
    }
}