# https://www.geeksforgeeks.org/problems/check-if-a-number-is-divisible-by-83957/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd

#User function Template for python3

class Solution:
    def DivisibleByEight(self,s):
        sz=len(s)
        tochk=""
        tochk2=int(s[sz-1])
        if tochk2%2!=0: 
            return -1
        if sz<=3:
            if int(s)%8!=0:
                return -1
            return 1
        tochk=tochk+s[sz-3]
        tochk=tochk+s[sz-2]
        tochk=tochk+s[sz-1]
        if int(tochk)%8==0:
            return 1
        return -1


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__=='__main__':
    t=int(input())
    for _ in range(t):
        S=input()
        ob=Solution()
        print(ob.DivisibleByEight(S))
# } Driver Code Ends