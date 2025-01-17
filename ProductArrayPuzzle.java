class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        //optimal 2 TC - O(2n)
        int n = arr.length;
        int[] result = new int[n];
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * arr[i - 1];
        }
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= arr[i];
        }
        return result;
        
        // //Optimal 1 TC - O(2n)
        // int n = arr.length;
        // int[] ans = new int[n];
        // int totalProduct = 1;
        // int zeroCount = 0;
        // for (int i = 0; i < n; i++) {
        //     if (arr[i] != 0) {
        //         totalProduct *= arr[i];
        //     } else {
        //         zeroCount++;
        //     }
        // }
        // for (int i = 0; i < n; i++) {
        //     if (zeroCount > 1) {
        //         ans[i] = 0;
        //     } else if (zeroCount == 1) {
        //         ans[i] = (arr[i] == 0) ? totalProduct : 0;
        //     } else {
        //         ans[i] = totalProduct / arr[i];
        //     }
        // }
        // return ans;
        
        // //Bruteforce (TLE) TC - O(n^2)
        // int n=arr.length;
        // int ans[]=new int[n];
        // for(int i=0;i<n;i++){
        //     int res=1;
        //     for(int j=0;j<n;j++){
        //         if(i==j) continue;
        //         res=res*arr[j];
        //     }
        //     ans[i]=res;
        // }
        // return ans;
    }
}