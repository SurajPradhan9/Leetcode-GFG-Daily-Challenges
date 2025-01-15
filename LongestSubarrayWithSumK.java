class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int n=arr.length;
        int maxLen=0;
        int sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum==k){
                maxLen=i+1;
            }
            int rem=sum-k;
            if(map.containsKey(rem)){
                maxLen=Math.max(maxLen,i-map.get(rem));
            }
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return maxLen;
    }
}
