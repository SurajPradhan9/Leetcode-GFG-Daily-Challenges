class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int n=words.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(words[i].length()>words[j].length()) continue;
                if(isPrefixAndSuffix2(words[i],words[j])){
                    count++;
                }
            }
        }
        return count;
    }
    //Method 1
    public static boolean isPrefixAndSuffix1(String str1,String str2){
        if(str2.startsWith(str1) && str2.endsWith(str1)){
            return true;
        }else{
            return false;
        }
    }
    //Method 2
    public static boolean isPrefixAndSuffix2(String str1,String str2){
        int n=str1.length();
        int m=str2.length();
        if(str2.substring(0,n).equals(str1) && str2.substring(m-n,m).equals(str1)){
            return true;
        }else{
            return false;
        }
    }
}