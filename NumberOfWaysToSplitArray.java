//Bruteforce TC - O(n-1)*n = O(n^2), SC - O(1) (Time limit Exceeded)
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n=nums.length;
        int count=0;
        int left=0;
        for(int i=0;i<n-1;i++){
            left+=nums[i];
            int right=0;
            for(int j=i+1;j<n;j++){
                right+=nums[j];
            }
            if(left>=right){
                count++;
            }
        }
        return count;
    }
}

//Optimal TC - O(2n) SC - O(1)
class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
        long left = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            left += nums[i];
            long right = totalSum - left;
            if (left >= right) {
                count++;
            }
        }
        return count;
    }
}