/*
https://www.geeksforgeeks.org/problems/you-and-your-books/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T > 0) {
            int N = sc.nextInt();
            int k = sc.nextInt();
            int ar[] = new int[N];
            //	int count = 0;
            for (int i = 0; i < N; i++) ar[i] = sc.nextInt();

            System.out.println(new Solution().max_Books(ar, N, k));
            T--;
        }
    }
}
// } Driver Code Ends



class Solution {
    
    boolean checkIsAValidCondition(int n, int k, int currentElementInArray, int currentIndexWhileTraversing){
        if(currentIndexWhileTraversing>=n||currentElementInArray>k) return false;
        return true;
    }
    
    long max_Books(int arr[], int n, int k) {
        long maxNumberBooksToCollect=0;
        for(int i=0; i<n; ++i){
            int currentElementInArray=arr[i], currentIndexWhileTraversing=i;
            long currentMaxNumberBooksToCollect=0;
            boolean isConsecutiveStacksOfBooksPresentForCurrentTraversal=false;
            while(checkIsAValidCondition(n, k, currentElementInArray, currentIndexWhileTraversing)){
                currentMaxNumberBooksToCollect+=arr[currentIndexWhileTraversing];
                currentIndexWhileTraversing+=1;
                if(currentIndexWhileTraversing>=n) break;
                currentElementInArray=arr[currentIndexWhileTraversing];
                if(!isConsecutiveStacksOfBooksPresentForCurrentTraversal){
                    isConsecutiveStacksOfBooksPresentForCurrentTraversal=true;
                }
            }
            if(isConsecutiveStacksOfBooksPresentForCurrentTraversal){
                i=currentIndexWhileTraversing-1;
            }
            maxNumberBooksToCollect=Math.max(maxNumberBooksToCollect, currentMaxNumberBooksToCollect);
        }
        return maxNumberBooksToCollect;
    }
}