# https://www.geeksforgeeks.org/problems/recursive-sequence1611/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd

#User function Template for python3

class Solution:
    def sequence(self, n):
        mod=1000000007
        res=1
        curcount=2
        curnum=2
        while(curcount<=n):
            tmpcurcount=curcount
            tmpcurcount-=1
            curmul=curnum
            curnum+=1
            while(tmpcurcount>0):
                curmul*=curnum
                curnum+=1
                curmul%=mod
                tmpcurcount-=1
            res+=curmul
            res%=mod
            curcount+=1
        res+=mod
        res%=mod
        return res


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        N = int(input())
        
        ob = Solution()
        print(ob.sequence(N))
# } Driver Code Ends