//Bruteforce TC - O(n^2)*m1*m2 (m1 and m2 are the lengths of the strings being compared in the contains() method.)
class Solution {
    public List<String> stringMatching(String[] words) {
        int n=words.length;
        List<String> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j) continue;
                if(words[j].contains(words[i])){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
}

//Bruteforce - if the interviewer asks without using the contains method, solve the Question .
// TC - O(n^2)*m1*m2
class Solution {
    public List<String> stringMatching(String[] words) {
        int n=words.length;
        List<String> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j || words[i].length()>words[j].length()) continue;
                if(isSubString(words[i],words[j])){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;
    }
    public static boolean isSubString(String sub,String word){
        int m1=sub.length();
        int m2=word.length();
        for(int j=0;j<m2;j++){
            boolean isMatch=true;
            int k=j;
            int i=0;
            while(i<m1){
                if(k>=m2|| word.charAt(k)!=sub.charAt(i)){
                    isMatch=false;
                    break;
                }
                k++;
                i++;
            }
            if(isMatch){
                return true;
            }
        }
        return false;
    }
}

//In leetcode the constraints are small so the above brute force approach is 90% faster
//If the constraints are big we have algorithms of patterns matching like -
//1. KMP (LPS - longest prefix suffix)
//2. Rabin Karp

