/*
https://www.geeksforgeeks.org/problems/check-if-a-number-is-power-of-another-number5442/1
*/

class Solution {
    public boolean isPower(int x, int y) {
        if(y==1) return true;
        else if(x==1&&y!=1) return false;
        else{
            while(true){
                if(y%x!=0) return false;
                int rem=y%x, quo=y/x;
                if(quo==1&&rem==0) return true;
                else if(quo==1) break;
                y=quo;
            }
        }
        return false;
    }
}