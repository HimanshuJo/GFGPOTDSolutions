/*
https://www.geeksforgeeks.org/problems/rotate-by-90-degree0356/1
*/

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) arr[i][j] = sc.nextInt();

            GFG g = new GFG();
            g.rotate(arr);
            printMatrix(arr);

            System.out.println("~");
        }
    }

    static void printMatrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) System.out.print(arr[i][j] + " ");
            System.out.println("");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class GFG {
    static void rotate(int mat[][]) {
        int rows=mat.length, columns=mat[0].length;
        int temporaryMatrix[][]=new int[rows][columns];
        int beginIndex=0;
        for(int i=rows-1; i>=0; --i){
            int currentRowMatrix[]=mat[i];
            for(int j=0; j<columns; ++j){
                temporaryMatrix[j][beginIndex]=currentRowMatrix[j];
            }
            beginIndex++;
        }
        for(int i=0; i<rows; ++i){
            for(int j=0; j<columns; ++j){
                mat[i][j]=temporaryMatrix[i][j];
            }
        }
    }
}