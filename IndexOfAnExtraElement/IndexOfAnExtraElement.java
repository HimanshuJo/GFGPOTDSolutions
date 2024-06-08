/*
https://www.geeksforgeeks.org/problems/index-of-an-extra-element/1
*/

//{ Driver Code Starts
import java.util.*;

class ExtraElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n - 1];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            for (int i = 0; i < n - 1; i++) b[i] = sc.nextInt();
            Solution g = new Solution();
            System.out.println(g.findExtra(n, a, b));
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/
class Solution {
    
    public static int binarySearchForIndexOfExtraElementInArr1(int n, int arr1[], int arr2[]){
        int currentLeftIndexInArr2=0, currentRightIndexInArr2=n-2, resultantIndexOfExtraElementInArr1=n-1;
        while(currentLeftIndexInArr2<=currentRightIndexInArr2){
            int currentMiddleIndexInArr2=currentLeftIndexInArr2+(currentRightIndexInArr2-currentLeftIndexInArr2)/2;
            if(arr2[currentMiddleIndexInArr2]>arr1[currentMiddleIndexInArr2]){
                resultantIndexOfExtraElementInArr1=currentMiddleIndexInArr2;
                currentRightIndexInArr2=currentMiddleIndexInArr2-1;
            } else if(arr2[currentMiddleIndexInArr2]<arr1[currentMiddleIndexInArr2]){
                currentRightIndexInArr2=currentMiddleIndexInArr2-1;
            } else currentLeftIndexInArr2=currentMiddleIndexInArr2+1;
        }
        return resultantIndexOfExtraElementInArr1;
    }
    
    public int findExtra(int n, int arr1[], int arr2[]) {
        int resultantIndexOfExtraElementInArr1=binarySearchForIndexOfExtraElementInArr1(n, arr1, arr2);
        return resultantIndexOfExtraElementInArr1;
    }
}