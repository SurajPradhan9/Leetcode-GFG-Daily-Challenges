//Bruteforce TC - O(n)+ O(n^2) SC - O(n)
class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int ans[]=new int[n];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            if(boxes.charAt(i)=='1'){
                map.put(i,1);
            }
        }
        for(int i=0;i<n;i++){
            for(Map.Entry<Integer,Integer> mp:map.entrySet()){
                ans[i]+=Math.abs(mp.getKey()-i);
            }
        }
        return ans;
    }
}

//Optimal - 1 TC - O(3n) SC - O(3n)
class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int left[]=new int[n];
        int right[]=new int[n];
        int ans[]=new int[n];
        int balls=boxes.charAt(0)-'0';
        for(int i=1;i<n;i++){
            left[i]=balls+left[i-1];
            if(boxes.charAt(i)=='1'){
                balls+=1;
            }
        }
        balls=boxes.charAt(n-1)-'0';
        for(int i=n-2;i>=0;i--){
            right[i]=balls+right[i+1];
            if(boxes.charAt(i)=='1'){
                balls+=1;
            }
        }
        for(int i=0;i<n;i++){
            ans[i]=left[i]+right[i];
        }
        return ans;
    }
}

//Optimal - 2 TC - O(2n) SC - O(n)
class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int ans[]=new int[n];
        int balls=boxes.charAt(0)-'0';
        for(int i=1;i<n;i++){
            ans[i]=balls+ans[i-1];
            balls+=boxes.charAt(i)-'0';
        }
        balls=boxes.charAt(n-1)-'0';
        int prevRight=0;
        int currRight=0;
        for(int i=n-2;i>=0;i--){
            currRight=prevRight+balls;
            prevRight=currRight;
            ans[i]+=currRight;
            balls+=boxes.charAt(i)-'0';
        }
        return ans;
    }
}