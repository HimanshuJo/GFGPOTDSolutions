# https://www.geeksforgeeks.org/problems/index-of-an-extra-element/1

class Solution:
    def findExtra(self,n,a,b):
        #add code here
        
        def binarySearchForIndexOfExtraElementInA(n, a, b):
            currentLeftIndexInB=0
            currentRightIndexInB=n-2
            resultantIndexOfExtraElementInA=n-1
            while(currentLeftIndexInB<=currentRightIndexInB):
                currentMiddleIndexInB=currentLeftIndexInB+(currentRightIndexInB-currentLeftIndexInB)//2
                if b[currentMiddleIndexInB]>a[currentMiddleIndexInB]:
                    resultantIndexOfExtraElementInA=currentMiddleIndexInB
                    currentRightIndexInB=currentMiddleIndexInB-1
                elif b[currentMiddleIndexInB]<a[currentMiddleIndexInB]:
                    currentRightIndexInB=currentMiddleIndexInB-1
                else:
                    currentLeftIndexInB=currentMiddleIndexInB+1
            return resultantIndexOfExtraElementInA
        
        resultantIndexOfExtraElementInA=binarySearchForIndexOfExtraElementInA(n, a, b)
        return resultantIndexOfExtraElementInA


#{ 
 # Driver Code Starts
if __name__ == "__main__":
    t = int(input())
    for i in range(t):
        n = int(input())
        a = list(map(int, input().split()))
        b = list(map(int, input().split()))
        print(Solution().findExtra(n, a, b))

# } Driver Code Ends