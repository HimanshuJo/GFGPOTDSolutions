/*
https://www.geeksforgeeks.org/problems/juggler-sequence3930/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts
// Initial Template for C#

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DriverCode {

class GFG {
    static void Main(string[] args) {
        int testcases; // Taking testcase as input
        testcases = Convert.ToInt32(Console.ReadLine());
        while (testcases-- > 0) // Looping through all testcases
        {
            long n = Convert.ToInt64(Console.ReadLine()); // Input for size of array
            Solution obj = new Solution();
            List<long> res = obj.jugglerSequence(n);
            for (int i = 0; i < res.Count; i++) {
                Console.Write(res[i] + " ");
            }
            Console.Write("\n");
        }
    }
}

}

// } Driver Code Ends


// User function Template for C#
class Solution {
    // Complete this function
    public List<long> jugglerSequence(long n) {
        List<long>res=new List<long>();
        res.Add(n);
        while(n!=1){
            if(n%2==0){
                long curr=(long)Math.Pow(n, 0.5);
                res.Add(curr);
                n=curr;
            } else{
                long curr=(long)Math.Pow(n, 1.5);
                res.Add(curr);
                n=curr;
            }
        }
        return res;
    }
}