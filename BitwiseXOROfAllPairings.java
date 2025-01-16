class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        //Optimal TC - O(n+m)
        int n=nums1.length;
        int m=nums2.length;
        int ans=0;
        if(m%2!=0){
            for(int i=0;i<n;i++){
                ans^=nums1[i];
            }
        }
        if(n%2!=0){
            for(int i=0;i<m;i++){
                ans^=nums2[i];
            }
        }
        return ans;

        // //Bruteforce (TLE) TC - O(n*m)
        // int n=nums1.length;
        // int m=nums2.length;
        // int xor=0;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         xor=xor^nums1[i]^nums2[j];
        //     }
        // }
        // return xor;
    }
}