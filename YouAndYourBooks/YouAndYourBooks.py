# https://www.geeksforgeeks.org/problems/you-and-your-books/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd

class Solution:
    #Your task is to complete this function
    #Function should return an integer
    #a - list/array containing height of stack's respectively
    def max_Books(self, n, k, arr):
        
        def checkIsAValidCondition(n, k, currentElementInArray, currentIndexWhileTraversing):
            if currentIndexWhileTraversing>=n or currentElementInArray>k:
                return False
            return True
        
        maxNumberBooksToCollect=0
        for i in range(0, n, 1):
            currentElementInArray=arr[i]
            currentIndexWhileTraversing=i
            currentMaxNumberBooksToCollect=0
            isConsecutiveStacksOfBooksPresentForCurrentTraversal=False
            while(checkIsAValidCondition(n, k, currentElementInArray, currentIndexWhileTraversing)):
                currentMaxNumberBooksToCollect+=arr[currentIndexWhileTraversing]
                currentIndexWhileTraversing+=1
                if currentIndexWhileTraversing>=n:
                    break
                currentElementInArray=arr[currentIndexWhileTraversing]
                if isConsecutiveStacksOfBooksPresentForCurrentTraversal==False:
                    isConsecutiveStacksOfBooksPresentForCurrentTraversal=True
            if isConsecutiveStacksOfBooksPresentForCurrentTraversal==True:
                i=currentIndexWhileTraversing-1
            maxNumberBooksToCollect=max(maxNumberBooksToCollect, currentMaxNumberBooksToCollect)
        return maxNumberBooksToCollect


#{ 
 # Driver Code Starts
if __name__ == '__main__':
    t = int(input())
    for i in range(t):
        temp = list(map(int, input().strip().split()))
        n = temp[0]
        k = temp[1]
        arr = list(map(int, input().strip().split()))
        ob = Solution()
        print(ob.max_Books(n, k, arr))
# Contributed by:Harshit Sidhwa

# } Driver Code Ends