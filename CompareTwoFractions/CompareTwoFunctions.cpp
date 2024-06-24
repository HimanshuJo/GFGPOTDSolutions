/*
https://www.geeksforgeeks.org/problems/compare-two-fractions4438/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts

#include <iostream>
#include <regex>
using namespace std;


// } Driver Code Ends

class Solution {
  public:
    string compareFrac(string str) {
        string frstnum="", secnum="", thrdnum="", frthnum="";
        int sz=str.size(), idx=0;
        while(idx<=sz-1){
            if(str[idx]=='/') break;
            frstnum+=str[idx];
            idx++;
        }
        idx++;
        while(idx<=sz-1){
            if(str[idx]==',') break;
            secnum+=str[idx];
            idx++;
        }
        idx++, idx++;
        while(idx<=sz-1){
            if(str[idx]=='/') break;
            thrdnum+=str[idx];
            idx++;
        }
        idx++;
        while(idx<=sz-1){
            frthnum+=str[idx];
            idx++;
        }
        int nm1=stoi(frstnum), nm2=stoi(secnum), nm3=stoi(thrdnum), nm4=stoi(frthnum);
        double res1=(double)nm1/nm2;
        double res2=(double)nm3/nm4;
        if(res1==res2) return "equal";
        else if(res1>res2) return frstnum+"/"+secnum;
        return thrdnum+"/"+frthnum;
    }
};


//{ Driver Code Starts.

int main() {
    Solution ob;
    int t;
    cin >> t;
    cin.ignore();
    for (int i = 0; i < t; i++) {

        string str;
        getline(cin, str);

        cout << ob.compareFrac(str) << endl;
    }
    return 0;
}

// } Driver Code Ends