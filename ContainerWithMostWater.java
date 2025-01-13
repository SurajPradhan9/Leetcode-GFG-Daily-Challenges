class Solution {

    public int maxWater(int arr[]) {
        // Code Here
        //Optimal TC -O(n)
        int n=arr.length;
        int maxWater=0;
        int left=0,right=n-1;
        while(left<right){
            int w=right-left;
            int ht=Math.min(arr[left],arr[right]);
            int currWater=w*ht;
            maxWater=Math.max(maxWater,currWater);
            if(arr[left]<arr[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
        
        // //Bruteforce (TLE) TC - O(n^2)
        // int n=arr.length;
        // int maxWater=0;
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         int w=j-i;
        //         int ht=Math.min(arr[i],arr[j]);
        //         int currWater=w*ht;
        //         maxWater=Math.max(maxWater,currWater);
        //     }
        // }
        // return maxWater;
    }
}