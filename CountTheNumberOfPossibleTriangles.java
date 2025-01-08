class Solution {
    // Function to count the number of possible triangles.
    static int countTriangles(int arr[]) {
        // code here
        
        //Optimal TC - O(nlogn)+ O(n^2) SC - O(logn)(for sorting)
        int n=arr.length;
        int count=0;
        Arrays.sort(arr);
        for(int i=n-1;i>=2;i--){
            int start=0;
            int end=i-1;
            while(start<end){
                if(arr[start]+arr[end]>arr[i]){
                    count+=(end-start);
                    end--;
                }else{
                    start++;
                }
            }
        }
        return count;
        
        // //Bruteforce O(n^3) (TLE)
        // int n=arr.length;
        // int count=0;
        // for(int i=0;i<n-2;i++){
        //     for(int j=i+1;j<n-1;j++){
        //         for(int k=j+1;k<n;k++){
        //             if(((arr[i]+arr[j])>arr[k]) && ((arr[i]+arr[k])>arr[j]) && ((arr[j]+arr[k])>arr[i])){
        //                 count++;
        //             }
        //         }
        //     }
        // }
        // return count;
    }
}
