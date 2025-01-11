class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        //Optimal TC - O(n) SC - O(n)
        int n=s.length();
        int i=0,j=0;
        int maxLen=0;
        HashMap<Character,Integer> map=new HashMap<>();
        while(j<n){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                i=Math.max(i,map.get(ch)+1);
            }
            maxLen=Math.max(maxLen,j-i+1);
            map.put(ch,j);
            j++;
        }
        return maxLen;
        
        // //Bruteforce TC - O(n^2) SC - O(n)
        // int n=s.length();
        // int maxLen=0;
        // for(int i=0;i<n;i++){
        //     HashMap<Character,Integer> map=new HashMap<>();
        //     for(int j=i;j<n;j++){
        //         if(map.containsKey(s.charAt(j))){
        //             break;
        //         }
        //         map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
        //         maxLen=Math.max(maxLen,j-i+1);
        //     }
        // }
        // return maxLen;
    }
}