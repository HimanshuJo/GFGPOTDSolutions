/*
https://www.geeksforgeeks.org/problems/trail-of-ones3242/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
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
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.numberOfConsecutiveOnes(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    
    public static final int MODULO=1000000007;
    
    public static long countTotalNonConsecutiveOnesBinaryString(int N, long[] memoization_ForTotalNonConsecutiveOnesBinaryStringPossibleForN){
        if(N==1) return 2L;
        if(N==2) return 3L;
        if(memoization_ForTotalNonConsecutiveOnesBinaryStringPossibleForN[N]!=-1) return memoization_ForTotalNonConsecutiveOnesBinaryStringPossibleForN[N];
        long countOfTotalNonConsecutiveOnesBinaryStringPossibleForN=0;
        countOfTotalNonConsecutiveOnesBinaryStringPossibleForN+=countTotalNonConsecutiveOnesBinaryString(N-1, memoization_ForTotalNonConsecutiveOnesBinaryStringPossibleForN)
                                                                +countTotalNonConsecutiveOnesBinaryString(N-2, memoization_ForTotalNonConsecutiveOnesBinaryStringPossibleForN);
        countOfTotalNonConsecutiveOnesBinaryStringPossibleForN%=MODULO;
        memoization_ForTotalNonConsecutiveOnesBinaryStringPossibleForN[N]=countOfTotalNonConsecutiveOnesBinaryStringPossibleForN;
        return memoization_ForTotalNonConsecutiveOnesBinaryStringPossibleForN[N];
    }
    
    public static long countTotalBinaryStrings(int N, long[] memoization_ForTotalBinaryStringsPossibleForN){
        if(N==1) return 2L;
        if(memoization_ForTotalBinaryStringsPossibleForN[N]!=-1) return memoization_ForTotalBinaryStringsPossibleForN[N];
        long countOfTotalBinaryStringsPossibleForN=0;
        countOfTotalBinaryStringsPossibleForN+=2*countTotalBinaryStrings(N-1, memoization_ForTotalBinaryStringsPossibleForN);
        countOfTotalBinaryStringsPossibleForN%=MODULO;
        memoization_ForTotalBinaryStringsPossibleForN[N]=countOfTotalBinaryStringsPossibleForN;
        return memoization_ForTotalBinaryStringsPossibleForN[N];
    }
    
    static int numberOfConsecutiveOnes(int n) {
        long[] memoization_ForTotalBinaryStringsPossibleForN=new long[n+1];
        long[] memoization_ForTotalNonConsecutiveOnesBinaryStringPossibleForN=new long[n+1];
        for(int i=0; i<=n; ++i){
            memoization_ForTotalBinaryStringsPossibleForN[i]=-1L;
            memoization_ForTotalNonConsecutiveOnesBinaryStringPossibleForN[i]=-1L;
        }
        long countOfTotalBinaryStringsPossibleForN=countTotalBinaryStrings(n, memoization_ForTotalBinaryStringsPossibleForN);
        long countOfTotalNonConsecutiveOnesBinaryStringPossibleForN=countTotalNonConsecutiveOnesBinaryString(n, memoization_ForTotalNonConsecutiveOnesBinaryStringPossibleForN);
        long numberOfBinaryStringsOfLengthNThatContainConsecutiveOnes=(countOfTotalBinaryStringsPossibleForN-countOfTotalNonConsecutiveOnesBinaryStringPossibleForN+MODULO);
        numberOfBinaryStringsOfLengthNThatContainConsecutiveOnes%=MODULO;
        return (int)numberOfBinaryStringsOfLengthNThatContainConsecutiveOnes;
    }
}
