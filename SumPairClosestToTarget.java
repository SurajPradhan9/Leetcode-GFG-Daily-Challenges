import java.util.*;
//Bruteforce (TLE) TC - O(n^2) SC - O(2)
class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        int n = arr.length;
        if (n < 2) return new ArrayList<>(); // No pairs possible
        
        int minDiff = Integer.MAX_VALUE;
        List<Integer> bestPair = new ArrayList<>();
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = arr[i];
                int b = arr[j];
                int sum = a + b;
                int diff = Math.abs(sum - target);
                
                // Check if this pair is closer to the target
                if (diff < minDiff) {
                    minDiff = diff;
                    bestPair.clear(); // Clear previous pair
                    bestPair.add(Math.min(a, b)); // Add in sorted order
                    bestPair.add(Math.max(a, b));
                } else if (diff == minDiff) {
                    // If the difference is the same, choose the pair with the maximum absolute difference
                    int absDiffCurrent = Math.abs(a - b);
                    int absDiffBest = Math.abs(bestPair.get(1) - bestPair.get(0));
                    if (absDiffCurrent > absDiffBest) {
                        bestPair.clear(); // Clear previous pair
                        bestPair.add(Math.min(a, b)); // Add in sorted order
                        bestPair.add(Math.max(a, b));
                    }
                }
            }
        }
        return bestPair;
    }
}

//Optimal TC - O(nlogn) + O(n) SC - O(logn)-(for Sorting)
class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        int n = arr.length;
        if (n < 2) return new ArrayList<>(); // Return empty if no pair exists.

        // Sort the array
        Arrays.sort(arr);

        // Initialize variables
        int left = 0, right = n - 1;
        int minDiff = Integer.MAX_VALUE;
        List<Integer> bestPair = new ArrayList<>();

        while (left < right) {
            int a = arr[left];
            int b = arr[right];
            int sum = a + b;
            int diff = Math.abs(sum - target);

            // Update the best pair if this sum is closer to the target
            if (diff < minDiff) {
                minDiff = diff;
                bestPair = Arrays.asList(a, b);
            } else if (diff == minDiff) {
                // If the difference is the same, choose the pair with the maximum absolute difference
                int absDiffCurrent = Math.abs(a - b);
                int absDiffBest = Math.abs(bestPair.get(1) - bestPair.get(0));
                if (absDiffCurrent > absDiffBest) {
                    bestPair = Arrays.asList(a, b);
                }
            }

            // Adjust pointers
            if (sum < target) {
                left++; // Increase sum by moving left pointer forward
            } else {
                right--; // Decrease sum by moving right pointer backward
            }
        }

        return bestPair;
    }
}