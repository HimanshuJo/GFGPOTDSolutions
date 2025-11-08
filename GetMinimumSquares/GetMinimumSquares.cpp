/*
https://www.geeksforgeeks.org/problems/get-minimum-squares0538/1
*/

class Solution {
  public:
  
    bool is_square(long long num){
        long long r=(long long)floor(sqrt((long double)num));
        return r*r==num;
    }
  
    int minSquares(int n) {
        if(is_square(n)) return 1;
        for(int i=1; i*i<=n; ++i){
            long long rem=n-i*i;
            if(is_square(rem)) return 2;
        }
        int m=n;
        while(m%4==0) m/=4;
        if(m%8==7) return 4;
        return 3;
    }
};