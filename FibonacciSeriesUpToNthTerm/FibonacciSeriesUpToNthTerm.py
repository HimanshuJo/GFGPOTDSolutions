# https://www.geeksforgeeks.org/problems/fibonacci-series-up-to-nth-term/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd

#User function Template for python3

class Solution:
    def series(self, n):
        res=[]
        prev=0
        curr=1
        mod=1000000000+7
        res.append(prev)
        while(len(res)<=n):
            res.append(curr)
            temp=curr
            curr+=prev
            curr%=mod
            prev=temp
        return res


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        N = int(input())
        ob = Solution()
        result = ob.series(N)
        print(*result)
# } Driver Code Ends