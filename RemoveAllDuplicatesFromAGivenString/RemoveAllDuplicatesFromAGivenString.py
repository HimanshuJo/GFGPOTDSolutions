# https://www.geeksforgeeks.org/problems/remove-all-duplicates-from-a-given-string4321/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd

#User function Template for python3
class Solution:

	
	def removeDuplicates(self,str):
	    res=""
	    mp={}
	    lngth=len(str)
	    for i in range(0, lngth, 1):
	        curr=str[i]
	        if not curr in mp:
	            res=res+curr
	            mp[curr]=curr
	    return res


#{ 
 # Driver Code Starts
#Initial Template for Python 3





if __name__ == '__main__':
    tc = int(input())
    while tc > 0:
        str = input().strip()
        ob = Solution()
        ans = ob.removeDuplicates(str)
        print(ans)
        tc -= 1

# } Driver Code Ends