//Bruteforce (TLE) TC - O(n*m), where n is the length of the string and m is the number of shifts.
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<shifts.length;i++){
            int first=shifts[i][0];
            int second=shifts[i][1];
            int direction=shifts[i][2];
            for(int j=first;j<=second;j++){
                int ascii=(int)sb.charAt(j);
                if(direction==1){
                    if(ascii==122){
                        ascii=97;
                    }else{
                        ascii+=1;
                    }
                }else{
                    if(ascii==97){
                        ascii=122;
                    }else{
                        ascii-=1;
                    }
                }
                sb.setCharAt(j,(char)ascii);
            }
        }
        return sb.toString();
    }
}
//Optimal TC - O(n+m)
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int arr[]=new int[n];
        for(int shift[]:shifts){
            if(shift[2]==1){
                arr[shift[0]]++;
                if(shift[1]+1<n){
                    arr[shift[1]+1]--;
                }
            }else{
                arr[shift[0]]--;
                if(shift[1]+1<n){
                    arr[shift[1]+1]++;
                }
            }
        }
        StringBuilder ans=new StringBuilder(s);
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+arr[i]%26;
            if(sum<0) sum+=26;
            char shiftedChar=(char)('a'+((s.charAt(i)-'a'+ sum)%26));
            ans.setCharAt(i,shiftedChar);
        }
        return ans.toString();
    }
}