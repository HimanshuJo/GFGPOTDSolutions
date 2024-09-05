# https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1

#User function Template for python3
class Solution:
    
    # Note that the size of the array is n-1
    def missingNumber(self, n, arr):
        temporaryArray=[]
        for i in range(0, n+1, 1):
            temporaryArray.append(0)
        lengthOfArr=len(arr)
        for i in range(0, lengthOfArr, 1):
            temporaryArray[arr[i]]+=1
        for i in range(1, n+1, 1):
            if temporaryArray[i]==0:
                return i
        return -1


#{ 
 # Driver Code Starts
#Initial Template for Python 3

t = int(input())
for _ in range(0, t):
    n = int(input())
    arr = list(map(int, input().split()))
    s = Solution().missingNumber(n, arr)
    print(s)

# } Driver Code Ends