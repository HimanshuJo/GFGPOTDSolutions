/*
https://www.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1
*/

class Solution {
  public:
  
    string genBinary(int num){
        if(num==1) return "1";
        string bn="";
        while(num!=1){
            int quo=num/2, rem=num%2;
            bn+=to_string(rem);
            num=quo;
        }
        bn+="1";
        reverse(bn.begin(), bn.end());
        return bn;
    }
  
    vector<string> generateBinary(int n) {
        vector<string>res;
        for(int i=1; i<=n; ++i){
            res.push_back(genBinary(i));
        }
        return res;
    }
};