/*
https://www.geeksforgeeks.org/problems/police-and-thieves--141631/1
*/

class Solution_OPT {
  public:
    int catchThieves(vector<char> &arr, int k) {
        vector<int>police, thief;
        int sz=arr.size();
        for(int i=0; i<sz; ++i){
            if(arr[i]=='P') police.push_back(i);
            else thief.push_back(i);
        }
        int i=0, j=0, res=0;
        while(i<police.size()&&j<thief.size()){
            if(abs(police[i]-thief[j])<=k){
                i++, j++, res++;
            } else if(thief[j]<police[i]) ++j;
            else ++i;
        }
        return res;
    }
};

// ------- ####### -------

class Solution_TLE {
  public:
    int catchThieves(vector<char> &arr, int k) {
        int sz=arr.size(), res=0;
        for(int i=sz-1; i>=0; --i){
            char curr=arr[i];
            if(curr=='P'){
                bool flag=false;
                if(i+k<=sz-1){
                    for(int j=i+k; j>=i; --j){
                        if(arr[j]=='T'){
                            arr[j]='#';
                            res++;
                            flag=true;
                            break;
                        }
                    }
                } else if(i+k>=sz){
                    for(int j=sz-1; j>=i; --j){
                        if(arr[j]=='T'){
                            arr[j]='#';
                            res++;
                            flag=true;
                            break;
                        }
                    }
                }
                if(!flag){
                    if(i-k>=0){
                        for(int j=i-1; j>=i-k; --j){
                            if(arr[j]=='T'){
                                arr[j]='#';
                                res++;
                                break;
                            }
                        }
                    } else if(i-k<0){
                        for(int j=i-1; j>=0; --j){
                            if(arr[j]=='T'){
                                arr[j]='#';
                                res++;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
};