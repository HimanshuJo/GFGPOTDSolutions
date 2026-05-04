/*
https://www.geeksforgeeks.org/problems/palindrome-numbers0942/1
*/

class Solution {
  public:
  
    bool isPalindrome(string str){
        int left=0, right=str.size()-1;
        while(left<right){
            if(str[left++]!=str[right--]) return false;
        }
        return true;
    }
  
    string toBinary(int n){
        string bn="";
        while(true){
            if(n==1) break;
            int quo=n/2, mod=n%2;
            bn+=to_string(mod);
            n=quo;
        }
        bn+="1";
        reverse(bn.begin(), bn.end());
        return bn;
    }
  
    bool isBinaryPalindrome(int n) {
        string tochk=toBinary(n);
        return isPalindrome(tochk);
    }
};