class Solution {
    int countPairs(int arr[], int target) {
        // Your code here
        //Optimal TC - O(nlogn + n)
        Arrays.sort(arr);
        int n=arr.length;
        int i=0,j=n-1;
        int count=0;
        while(i!=j){
            if((arr[i]+arr[j])<target){
                count+=(j-i);
                i++;
            }else{
                j--;
            }
        }
        return count;
        
        // //Bruteforce (TLE) TC - O(n^2)
        // int count=0;
        // int n=arr.length;
        // for(int i=0;i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         if((arr[i]+arr[j])<target){
        //             count++;
        //         }
        //     }
        // }
        // return count;
    }
}