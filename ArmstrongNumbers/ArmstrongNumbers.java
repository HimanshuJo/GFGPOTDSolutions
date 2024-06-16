/*
https://www.geeksforgeeks.org/problems/armstrong-numbers2727/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.armstrongNumber(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static String armstrongNumber(int n){
        int armstrongNumberToCheck=n, currentSumCubesOfDigitsOfN=0;
        while(n>10){
            int remainingNumberAfterDivisionWithTen=n/10,
                lastDigitOfCurrentN=n%10;
            currentSumCubesOfDigitsOfN+=(lastDigitOfCurrentN*lastDigitOfCurrentN*lastDigitOfCurrentN);
            n=remainingNumberAfterDivisionWithTen;
        }
        currentSumCubesOfDigitsOfN+=(n*n*n);
        return currentSumCubesOfDigitsOfN==armstrongNumberToCheck?"Yes":"No";
    }
}