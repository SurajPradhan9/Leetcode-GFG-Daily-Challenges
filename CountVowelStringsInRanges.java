//Bruteforce TC - O(m*n) SC - O(m)
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int m=queries.length;
        int ans[]=new int[m];
        for(int i=0;i<m;i++){
            int start=queries[i][0];
            int end=queries[i][1];
            int count=0;
            for(int j=start;j<=end;j++){
                int wordLen=words[j].length();
                boolean firstChar=isVowel(words[j].charAt(0));
                boolean lastChar=isVowel(words[j].charAt(wordLen-1));
                if(firstChar==true && lastChar==true){
                    count++;
                }
            }
            ans[i]=count;
        }
        return ans;
    }
    public static boolean isVowel(char ch){
        String str="aeiou";
        if(str.indexOf(ch)!=-1){
            return true;
        }else{
            return false;
        }
    }
}

//Optimal TC - O(m+n) SC - O(m+n)
class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n=words.length;
        int m=queries.length;
        int ans[]=new int[m];
        int prefixSum[]=new int[n];
        for(int i=0;i<n;i++){
            int wordLen=words[i].length();
            boolean firstChar=isVowel(words[i].charAt(0));
            boolean lastChar=isVowel(words[i].charAt(wordLen-1));
            if(firstChar==true && lastChar==true){
                prefixSum[i]=1;
            }
            if(i>0){
                prefixSum[i]+=prefixSum[i-1];
            }
        }
        for(int i=0;i<m;i++){
            int count=prefixSum[queries[i][1]] - (queries[i][0]>0 ? prefixSum[queries[i][0]-1] : 0);
            ans[i]=count;
        }
        return ans;
    }
    public static boolean isVowel(char ch){
    String str="aeiou";
        if(str.indexOf(ch)!=-1){
            return true;
        }else{
            return false;
        }
    }
}