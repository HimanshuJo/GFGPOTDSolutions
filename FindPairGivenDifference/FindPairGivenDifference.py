# https://www.geeksforgeeks.org/problems/find-pair-given-difference1559/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd

from typing import List


class Solution:
    def findPair(self, n : int, x : int, arr : List[int]) -> int:
        
        def performBinarySearch(otherElementNeededToFormPair, arr, currentIndexInArray):
            leftBoundary=0
            rightBoundary=len(arr)-1
            isOtherElementNeededToFormPairPresent=False
            while(leftBoundary<=rightBoundary):
                middleOfCurrentRange=leftBoundary+(rightBoundary-leftBoundary)//2
                if arr[middleOfCurrentRange]==otherElementNeededToFormPair and middleOfCurrentRange!=currentIndexInArray:
                    isOtherElementNeededToFormPairPresent=True
                    break
                elif arr[middleOfCurrentRange]>otherElementNeededToFormPair:
                    rightBoundary=middleOfCurrentRange-1
                else:
                    leftBoundary=middleOfCurrentRange+1
            return  isOtherElementNeededToFormPairPresent
                        
            
        arr.sort()
        for i in range(0, n, 1):
            currentElementInArray=arr[i]
            otherElementNeededToFormPair=currentElementInArray+x
            doesOtherElementNeededToFormPairPresent=performBinarySearch(otherElementNeededToFormPair, arr, i)
            if doesOtherElementNeededToFormPairPresent:
                return 1
        return -1
        



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

        n = int(input())

        x = int(input())

        arr = IntArray().Input(n)

        obj = Solution()
        res = obj.findPair(n, x, arr)

        print(res)

# } Driver Code Ends