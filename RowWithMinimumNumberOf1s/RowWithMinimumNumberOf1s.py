# https://www.geeksforgeeks.org/problems/row-with-minimum-number-of-1s5430/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd

#User function Template for python3

import sys

class Solution:
    def minRow(self,n,m,a):
        minRwCount=sys.maxsize
        idxRes=0
        for i in range(0, n, 1):
            curcount=0
            for j in range(0, m, 1):
                if a[i][j]==1:
                    curcount+=1
            if curcount<minRwCount:
                minRwCount=curcount
                idxRes=i
        return idxRes+1


#{ 
 # Driver Code Starts
#Initial Template for Python 3

import math
        
if __name__=='__main__':
    t=int(input())
    for _ in range(t):
        N,M=map(int,input().strip().split(" "))
        A=[]
        for i in range(N):
            B=list(map(int,input().strip().split(" ")))
            A.append(B)
        ob=Solution()
        print(ob.minRow(N,M,A))
# } Driver Code Ends