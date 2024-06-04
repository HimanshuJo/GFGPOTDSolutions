/*
https://www.geeksforgeeks.org/problems/binary-representation-of-next-number3648/1?utm_source=geeksforgeeks&utm_medium=newui_home&utm_campaign=potd
*/

//{ Driver Code Starts

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => { inputString += inputStdin; });

process.stdin.on('end', _ => {
    inputString =
        inputString.trim().split("\n").map(string => { return string.trim(); });

    main();
});

function readLine() { return inputString[currentLine++]; }

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for (; i < t; i++) {
        let s = readLine();
        let obj = new Solution();
        let res = obj.binaryNextNumber(s);
        console.log(res);
    }
}

// } Driver Code Ends



class Solution {
    
    replaceAt(currentString, index, replacement) {
        return currentString.substring(0, index) + replacement + currentString.substring(index + replacement.length);
    }
    
    /**
    * @param string s

    * @returns string
    */
    binaryNextNumber(s) {
        let sAfterRemovingPrefixZeros="";
        let lengthOfS=s.length;
        let initialIndexInS=0
        while(s[initialIndexInS]==='0'){
            initialIndexInS++;
            if(initialIndexInS==lengthOfS){
                return "1";
            }
        }
        for(let index=initialIndexInS; index<lengthOfS; ++index){
            sAfterRemovingPrefixZeros+=s[index];
        }
        let lengthOfSAfterRemovingPrefixZeros=sAfterRemovingPrefixZeros.length;
        for(let index=lengthOfSAfterRemovingPrefixZeros-1; index>=0; --index){
            if(sAfterRemovingPrefixZeros[index]==='0'){
                let replacingCharacterAtIndexInSAfterRemovingPrefixZeros=this.replaceAt(sAfterRemovingPrefixZeros, index, '1');
                return replacingCharacterAtIndexInSAfterRemovingPrefixZeros;
            } else{
                let replacingCharacterAtIndexInSAfterRemovingPrefixZeros=this.replaceAt(sAfterRemovingPrefixZeros, index, '0');
                sAfterRemovingPrefixZeros=replacingCharacterAtIndexInSAfterRemovingPrefixZeros;
            }
        }
        let ifFirstCharWasOneThenAddingOneInSAfterRemovingPrefixZeros=sAfterRemovingPrefixZeros.slice(0, 0)+'1'+sAfterRemovingPrefixZeros.slice(0);
        return ifFirstCharWasOneThenAddingOneInSAfterRemovingPrefixZeros;
    }
}
