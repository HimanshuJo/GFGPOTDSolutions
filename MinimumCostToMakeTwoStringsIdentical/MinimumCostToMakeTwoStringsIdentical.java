/*
https://www.geeksforgeeks.org/problems/minimum-cost-to-make-two-strings-identical1107/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
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
            String X = sc.next();
            String Y = sc.next();
            int costX = sc.nextInt();
            int costY = sc.nextInt();

            Solution ob = new Solution();
            System.out.println(ob.findMinCost(X, Y, costX, costY));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    int depthFirstSearchTraversal_forStrings(String x, String y, int beginTraversalIndexForX, int beginTraversalIndexForY, int[][] memoization){
        if(beginTraversalIndexForX==0||beginTraversalIndexForY==0) return 0;
        if(memoization[beginTraversalIndexForX][beginTraversalIndexForY]!=-1) return memoization[beginTraversalIndexForX][beginTraversalIndexForY];
        int longestCommonSubsequenceForXAndY=0;
        if(x.charAt(beginTraversalIndexForX-1)==y.charAt(beginTraversalIndexForY-1)){
            longestCommonSubsequenceForXAndY=Math.max(longestCommonSubsequenceForXAndY, 
                                                      1+depthFirstSearchTraversal_forStrings(x, y, beginTraversalIndexForX-1, beginTraversalIndexForY-1, memoization));
        } else{
            longestCommonSubsequenceForXAndY=Math.max(longestCommonSubsequenceForXAndY, 
                                             Math.max(depthFirstSearchTraversal_forStrings(x, y, beginTraversalIndexForX-1, beginTraversalIndexForY, memoization), 
                                                      depthFirstSearchTraversal_forStrings(x, y, beginTraversalIndexForX, beginTraversalIndexForY-1, memoization)));
        }
        return memoization[beginTraversalIndexForX][beginTraversalIndexForY]=longestCommonSubsequenceForXAndY;
    }
    
    public int findLongestCommonSubsequenceForXAndY(String x, String y){
        int lengthOfX=x.length(), lengthOfY=y.length();
        int[][] memoization=new int[lengthOfX+1][lengthOfY+1];
        for(int i=0; i<=lengthOfX; ++i){
            for(int j=0; j<=lengthOfY; ++j){
                memoization[i][j]=-1;
            }
        }
        int beginTraversalIndexForX=lengthOfX, beginTraversalIndexForY=lengthOfY;
        return depthFirstSearchTraversal_forStrings(x, y, beginTraversalIndexForX, beginTraversalIndexForY, memoization);
    }
    
    public int findMinCost(String x, String y, int costX, int costY) {
        int longestCommonSubsequenceForXAndY=findLongestCommonSubsequenceForXAndY(x, y);
        int lengthOfX=x.length(), lengthOfY=y.length();
        int minimumCostRequiredToMakeGivenStringsIdentical=0;
        int charactersNeededToBeRemovedFromX=Math.abs(longestCommonSubsequenceForXAndY-lengthOfX);
        int charactersNeededToBeRemovedFromY=Math.abs(longestCommonSubsequenceForXAndY-lengthOfY);
        minimumCostRequiredToMakeGivenStringsIdentical+=(charactersNeededToBeRemovedFromX*costX)+(charactersNeededToBeRemovedFromY*costY);
        return minimumCostRequiredToMakeGivenStringsIdentical;
    }
}
