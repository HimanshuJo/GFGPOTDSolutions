# https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1


#User function Template for python3

class Solution:
    def segregate0and1(self, arr):
        lengthOfArr=len(arr)
        beginIndex=0
        countOfZeros=0
        for i in range(0, lengthOfArr, 1):
            if arr[i]==0:
                countOfZeros+=1
        while(countOfZeros>0):
            arr[beginIndex]=0
            beginIndex+=1
            countOfZeros-=1
        while(beginIndex<=lengthOfArr-1):
            arr[beginIndex]=1
            beginIndex+=1


#{ 
 # Driver Code Starts
class IntArray:

    def __init__(self) -> None:
        pass

    def Input(self, n):
        arr = [int(i) for i in input().strip().split()]  #array input
        return arr

    def Print(self, arr):
        for i in arr:
            print(i, end=" ")
        print()


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):

        arr = list(map(int, input().strip().split()))

        obj = Solution()
        obj.segregate0and1(arr)

        print(*arr)

# } Driver Code Ends