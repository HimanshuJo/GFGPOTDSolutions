/*
https://www.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1
*/

class Solution_TLE {
  public:
  
    void rotateRight(string &s, int k) {
        int n = s.size();
        if (n == 0) return;
    
        k %= n;
        reverse(s.begin(), s.end());
        reverse(s.begin(), s.begin() + k);
        reverse(s.begin() + k, s.end());
    }
  
    void rotateLeft(string &s, int k) {
        int n = s.size();
        if (n == 0) return;
    
        k %= n;
        reverse(s.begin(), s.begin() + k);
        reverse(s.begin() + k, s.end());
        reverse(s.begin(), s.end());
    }
      
    bool areRotations(string &s1, string &s2) {
        int sz=s1.size();
        string temp=s1;
        for(int i=0; i<sz; ++i){
            rotateLeft(temp, i+1);
            if(temp==s2) return true;
            temp=s1;
        }
        temp=s1;
        for(int i=0; i<sz; ++i){
            rotateRight(temp, i+1);
            if(temp==s2) return true;
            temp=s1;
        }
        return false;
    }
};

// ------- ####### -------

class Solution {
  public:
    bool areRotations(string &s1, string &s2) {
        string combined=s1+s1;
        auto itr=combined.find(s2);
        return itr!=string::npos;
    }
};