class Solution {
    public int prefixCount(String[] words, String pref) {
        int n=words.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(pref.length()>words[i].length()) continue;
            if(words[i].substring(0,pref.length()).equals(pref)){
                count++;
            }
        }
        return count;
    }
}

class Solution {
    public int prefixCount(String[] words, String pref) {
        int n=words.length;
        int count=0;
        for(int i=0;i<n;i++){
            if(pref.length()>words[i].length()) continue;
            if(words[i].startsWith(pref)){
                count++;
            }
        }
        return count;
    }
}