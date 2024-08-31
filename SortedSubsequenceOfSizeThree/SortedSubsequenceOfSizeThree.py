# https://www.geeksforgeeks.org/problems/sorted-subsequence-of-size-3/1

#User function Template for python3



class Solution:
    def find3Numbers(self, arr):
        lengthOfArr=len(arr)
        resultantListOfThreeElements=[]
        for i in range(0, lengthOfArr, 1):
            if i+1<=lengthOfArr:
                currentElement=arr[i]
                for j in range(i+1, lengthOfArr, 1):
                    nextElement=arr[j]
                    if nextElement>currentElement and j+1<=lengthOfArr:
                        for k in range(j+1, lengthOfArr, 1):
                            finalElement=arr[k]
                            if finalElement>nextElement:
                                resultantListOfThreeElements.append(currentElement)
                                resultantListOfThreeElements.append(nextElement)
                                resultantListOfThreeElements.append(finalElement)
                                return resultantListOfThreeElements
        return resultantListOfThreeElements


#{ 
 # Driver Code Starts
#Initial Template for Python 3


def isSubSequence(v1, v2):
    m = len(v2)
    n = len(v1)
    j = 0  # For index of v2
    # Traverse v1 and v2
    for i in range(n):
        if j < m and v1[i] == v2[j]:
            j += 1
    return j == m


if __name__ == "__main__":
    t = int(input())
    for _ in range(t):
        arr = list(map(int, input().split()))
        n = len(arr)
        obj = Solution()
        res = obj.find3Numbers(arr)
        if len(res) != 0 and len(res) != 3:
            print(-1)
        else:
            if not res:
                print(0)
            elif res[0] < res[1] < res[2] and isSubSequence(arr, res):
                print(1)
            else:
                print(-1)

# } Driver Code Ends