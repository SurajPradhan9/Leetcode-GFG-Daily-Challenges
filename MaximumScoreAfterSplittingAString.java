//Bruteforce TC - O(n^2) SC - O(1)
class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int max=Integer.MIN_VALUE;
        int leftSubstring=0;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)=='0'){
                leftSubstring++;
            }
            int rightSubstring=0;
            for(int j=i+1;j<n;j++){
                if(s.charAt(j)=='1'){
                    rightSubstring++;
                }
            }
            max=Math.max(max,leftSubstring+rightSubstring);
        }
        return max;
    }
}

//Optimal TC - O(2n) SC - O(1)
class Solution {
    public int maxScore(String s) {
        int n=s.length();
        int ones=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                ones++;
            }
        }
        int zeros=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)=='0'){
                zeros++;
            }else{
                ones--;
            }
            max=Math.max(max,ones+zeros);
        }
        return max;
    }
}