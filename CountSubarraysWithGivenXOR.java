import java.util.HashMap;
class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        
        //Optimal TC - O(n) SC - O(n) 
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=0;
        int xr=0;
        map.put(xr,1);
        for(int i=0;i<n;i++){
            xr^=arr[i];
            int x=xr^k;
            count+=map.getOrDefault(x,0);
            map.put(xr,map.getOrDefault(xr,0)+1);
        }
        return count;
        
        // //Better TC - O(n^2) SC - O(1) - Time limit Exceeded
        // int n=arr.length;
        // int count=0;
        // for(int i=0;i<n;i++){
        //     int xor=0;
        //     for(int j=i;j<n;j++){
        //         xor^=arr[j];
        //         if(xor==k){
        //           count++;
        //         }
        //     }
        // }
        // return count;
        
        // //Bruteforce TC - O(n^3) SC - O(1) - Time limit Exceeded
        // int n=arr.length;
        // int count=0;
        // for(int i=0;i<n;i++){
        //     for(int j=i;j<n;j++){
        //         int xor=0;
        //         for(int l=i;l<=j;l++){
        //             xor^=arr[l];
        //         }
        //         if(xor==k){
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }
}
