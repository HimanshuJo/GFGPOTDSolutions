/*
https://www.geeksforgeeks.org/problems/peak-element/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
//Initial Template for C#

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DriverCode
{

    class GFG
    {
        static void Main(string[] args)
        {
            int testcases;// Taking testcase as input
            testcases = Convert.ToInt32(Console.ReadLine());
            while (testcases-- > 0)// Looping through all testcases
            {

                int n = Convert.ToInt32(Console.ReadLine());
                int[] arr = new int[n];
                string elements = Console.ReadLine().Trim();
                elements = elements + " " + "0";
                int[] arr2 = Array.ConvertAll(elements.Split(), int.Parse);
                for (int i = 0; i < n; i++)
                {
                    arr[i] = arr2[i];
                }
                Solution obj = new Solution();
                var A = obj.peakElement(arr, n);
                for (int i = 0; i < n; i++)
                {
                    arr[i] = arr2[i];
                }
                if(A<0 && A>=n)
        		    Console.WriteLine(0);
        		else
        		{
        		    int f = 0;
            		if(n==1 && A==0)
            		    f=1;
            		else if(A==0 && arr[0]>=arr[1])
            		    f=1;
            		else if(A==n-1 && arr[n-1]>=arr[n-2])
            		    f=1;
            		else if(arr[A]>=arr[A+1] && arr[A]>= arr[A-1])
            		    f=1;
            		else
            		    f=0;
            		Console.WriteLine(f);
        		}
                
            }

        }
    }

    
// } Driver Code Ends
//User function Template for C#

    class Solution
    {
        public int peakElement(int[] arr, int n)
        {
            List<int>res=new List<int>();
            int prev=-1;
            for(int i=0; i<n; ++i){
                if(i+1<=n-1){
                    if(arr[i]>=prev&&arr[i]>=arr[i+1]){
                        res.Add(i); 
                    }
                } else{
                    if(arr[i]>=prev){
                        res.Add(i);
                    }
                }
                prev=arr[i];
            }
            return res[0];
        }
    }

}

//{ Driver Code Starts.
// } Driver Code Ends