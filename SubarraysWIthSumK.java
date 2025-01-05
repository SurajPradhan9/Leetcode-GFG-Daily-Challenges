import java.util.*; 
class Solution {
    public int countSubarrays(int arr[], int k) {
        int n=arr.length;
        int count=0;
        int sum=0;
        HashMap<Integer,Integer> prefixSum=new HashMap<>();
        prefixSum.put(0,1);
        for(int i=0;i<n;i++){
            sum+=arr[i];
            int rem=sum-k;
            count=count+prefixSum.getOrDefault(rem,0);
            prefixSum.put(sum,prefixSum.getOrDefault(sum,0)+1);
        }
        return count;
    }
}