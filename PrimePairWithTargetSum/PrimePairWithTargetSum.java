/*
https://www.geeksforgeeks.org/problems/sum-of-prime4751/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.ArrayList;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.getPrimes(n);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public static void sieveOfEratosthenes(int N, ArrayList<Integer>allPrimesUntilN, ArrayList<Boolean>isTheNumberPrime){
        for(int i=2; i*i<=N; ++i){
            if(isTheNumberPrime.get(i)==true){
                for(int j=2; i*j<=N; ++j){
                    isTheNumberPrime.set(i*j, false);
                }
            }
        }
        for(int i=1; i<=N; ++i){
            if(isTheNumberPrime.get(i)==true) allPrimesUntilN.add(i);
        }
    }
    
    public static void generateAllPrimesUntilN(int N, ArrayList<Integer>allPrimesUntilN){
        ArrayList<Boolean>isTheNumberPrime=new ArrayList<>();
        for(int i=0; i<=N+10; ++i){
            isTheNumberPrime.add(true);
        }
        isTheNumberPrime.set(0, false);
        isTheNumberPrime.set(1, false);
        sieveOfEratosthenes(N, allPrimesUntilN, isTheNumberPrime);
    }
    
    public static ArrayList<Integer> getPrimes(int n) {
        ArrayList<Integer>allPrimesUntilN=new ArrayList<>();
        ArrayList<Integer>resultantPrimePair=new ArrayList<>();
        generateAllPrimesUntilN(n, allPrimesUntilN);
        int leftIndex=0, rightIndex=allPrimesUntilN.size()-1;
        while(leftIndex<=rightIndex){
            int sumOfPrimesAtCurrentLeftRightIndex=allPrimesUntilN.get(leftIndex)+allPrimesUntilN.get(rightIndex);
            if(sumOfPrimesAtCurrentLeftRightIndex==n){
                resultantPrimePair.add(allPrimesUntilN.get(leftIndex));
                resultantPrimePair.add(allPrimesUntilN.get(rightIndex));
                break;
            } else if(sumOfPrimesAtCurrentLeftRightIndex>n){
                rightIndex-=1;
            } else leftIndex+=1;
        }
        if(resultantPrimePair.size()==0){
            resultantPrimePair.add(-1);
            resultantPrimePair.add(-1);
        }
        return resultantPrimePair;
    }
}
