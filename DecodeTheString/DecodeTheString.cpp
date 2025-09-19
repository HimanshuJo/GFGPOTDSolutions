/*
https://www.geeksforgeeks.org/problems/decode-the-string2444/1
*/

class Solution {
public:
    string decodedString(string &s) {
        stack<string> strStack;
        stack<int> numStack;
        string curr = "";
        int num = 0;

        for (char c : s) {
            if (isdigit(c)) {
                num = num * 10 + (c - '0');
            } 
            else if (c == '[') {
                numStack.push(num);
                strStack.push(curr);
                num = 0;
                curr = "";
            } 
            else if (c == ']') {
                int repeat = numStack.top(); numStack.pop();
                string temp = strStack.top(); strStack.pop();
                while (repeat--) temp += curr;
                curr = temp;
            } 
            else {
                curr += c;
            }
        }

        return curr;
    }
};
