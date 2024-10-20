/*
https://www.geeksforgeeks.org/problems/nearest-multiple-of-102437/1
*/

//{ Driver Code Starts
#include <iostream>
using namespace std;


// } Driver Code Ends

#include<algorithm>

class Solution {
  public:
  
    string subtractLargeNumber(string largeNum, int subNum) {
        string subNumStr = to_string(subNum);
        reverse(largeNum.begin(), largeNum.end());
        reverse(subNumStr.begin(), subNumStr.end());
    
        string result = "";
        int carry = 0;
    
        int maxLength = max(largeNum.length(), subNumStr.length());

        for (int i = 0; i < maxLength; ++i) {
            int digitLarge = (i < largeNum.length()) ? (largeNum[i] - '0') : 0;
            int digitSub = (i < subNumStr.length()) ? (subNumStr[i] - '0') : 0;

            int diff = digitLarge - digitSub - carry;
    
            if (diff < 0) {
                diff += 10;
                carry = 1;
            } else {
                carry = 0;
            }
    
            result.push_back(diff + '0');
        }
    
        return result;
    }
  
    string roundToNearest(string str) {
        int lstdigChng1=str[str.size()-1]-'0';
        int lstdigChng2=str[str.size()-1]-'0';
        int count1=0, count2=0;
        string fnnum="";
        while(lstdigChng1!=0){
            if(lstdigChng1==9){
                count1++;
                break;
            } else{
                lstdigChng1++;
                count1++;   
            }
        }
        while(lstdigChng2!=0){
            if(lstdigChng2==1){
                count2++;
                break;
            } else{
                lstdigChng2--;
                count2++;
            }
        }
        if(count1<count2){
            int carry=count1;
            for(int i=str.size()-1; i>=0; --i){
                int curnm=str[i]-'0';
                curnm+=carry;
                carry=0;
                if(i!=0){
                    if(curnm>=10){
                        int quo=curnm/10, rem=curnm%10;
                        carry=quo;
                        fnnum+=to_string(rem);
                    } else fnnum+=to_string(curnm);   
                } else{
                    reverse(fnnum.begin(), fnnum.end());
                    fnnum.insert(0, to_string(curnm));
                }
            }
        } else{
            fnnum=subtractLargeNumber(str, count2);
            reverse(fnnum.begin(), fnnum.end());
        }
        return fnnum;
    }
};

//{ Driver Code Starts.

int main() {

    int t;
    cin >> t;
    while (t--) {
        string str;
        cin >> str;
        Solution ob;
        cout << ob.roundToNearest(str) << endl;
    }

    return 0;
}
// } Driver Code Ends