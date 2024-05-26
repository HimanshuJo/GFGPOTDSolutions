# https://www.geeksforgeeks.org/problems/minimum-cost-to-make-two-strings-identical1107/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd

#User function Template for python3
class Solution:
	def findMinCost(self, x, y, costX, costY):
	    
	    def depthFirstTraversal_forStrings(x, y, beginTraversalIndexForX, beginTraversalIndexForY, memoization):
	        if beginTraversalIndexForX==0 or beginTraversalIndexForY==0:
	            return 0
	        if memoization[beginTraversalIndexForX][beginTraversalIndexForY]!=-1:
	            return memoization[beginTraversalIndexForX][beginTraversalIndexForY]
	        longestCommonSubsequenceForXAndY=0
	        if x[beginTraversalIndexForX-1]==y[beginTraversalIndexForY-1]:
	            longestCommonSubsequenceForXAndY=max(longestCommonSubsequenceForXAndY, 1+depthFirstTraversal_forStrings(x, y, beginTraversalIndexForX-1, beginTraversalIndexForY-1, memoization))
	        else:
	            longestCommonSubsequenceForXAndY=max(longestCommonSubsequenceForXAndY, max(depthFirstTraversal_forStrings(x, y, beginTraversalIndexForX-1, beginTraversalIndexForY, memoization), depthFirstTraversal_forStrings(x, y, beginTraversalIndexForX, beginTraversalIndexForY-1, memoization)))
            memoization[beginTraversalIndexForX][beginTraversalIndexForY]=longestCommonSubsequenceForXAndY
            return memoization[beginTraversalIndexForX][beginTraversalIndexForY]
            
	    def findLongestCommonSubsequence(x, y):
	        lengthOfX=len(x)
	        lengthOfY=len(y)
	        memoization=[]
	        for i in range(0, lengthOfX+1, 1):
	            memoization.append([])
	            for j in range(0, lengthOfY+1, 1):
	                memoization[i].append(-1)
	        beginTraversalIndexForX=lengthOfX
	        beginTraversalIndexForY=lengthOfY
	        return depthFirstTraversal_forStrings(x, y, beginTraversalIndexForX, beginTraversalIndexForY, memoization)
	    
	    longestCommonSubsequenceForXAndY=findLongestCommonSubsequence(x, y)
	    lengthOfX=len(x)
	    lengthOfY=len(y)
	    minimumCostRequiredToMakeGivenStringIdentical=0
	    charactersNeededToBeRemovedFromX=abs(longestCommonSubsequenceForXAndY-lengthOfX)
	    charactersNeededToBeRemovedFromY=abs(longestCommonSubsequenceForXAndY-lengthOfY)
	    minimumCostRequiredToMakeGivenStringIdentical+=(charactersNeededToBeRemovedFromX*costX)+(charactersNeededToBeRemovedFromY*costY)
	    return minimumCostRequiredToMakeGivenStringIdentical


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    T = int(input())
    for i in range(T):
        X, Y, costX, costY = input().split()
        costX = int(costX)
        costY = int(costY)
        ob = Solution()
        ans = ob.findMinCost(X, Y, costX, costY)
        print(ans)

# } Driver Code Ends