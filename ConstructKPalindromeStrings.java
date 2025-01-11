//TC - O(n+26)
class Solution {
    public boolean canConstruct(String s, int k) {
        int n=s.length();
        // If the string length is less than k, we cannot construct k palindromes
        if(n<k) return false;
        // If the string length is exactly k, we can construct k palindromes 
        // (each character can form its own palindrome)
        if(n==k) return true;
        //find frequency
        int freq[]=new int[26];
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']++; //converting character to index
        }
        //find odd count(no need to find even count because if there are all even it is true)
        int oddCount=0;
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                oddCount++;
            }
        }
        return oddCount <= k; // - If all character frequencies are even, oddCount is 0, which means we can form k palindromes easily (as no odd characters need to be placed in the middle).
// - If oddCount is greater than k, it is not possible to form k palindromes because each odd character needs its own palindrome for placement.
// - This condition covers both cases: 
//   1. When all frequencies are even (oddCount = 0).
//   2. When oddCount is within the limit of k.
    }
}