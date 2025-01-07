//Bruteforce TC - O(n^2) SC - O(1)
class Solution {
    int countPairs(int arr[], int target) {
        int n = arr.length;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((arr[i] + arr[j]) == target) {
                    count++;
                }
            }
        }
        return count;
    }
}

//Better TC - O(n) SC - O(n)
class Solution {
    int countPairs(int arr[], int target) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            int complement = target - num;

            // Check if complement exists
            if (freqMap.containsKey(complement)) {
                count += freqMap.get(complement);
            }

            // Update the frequency map
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        return count;
    }
}

//Optimal TC - O(n) SC - O(1)
class Solution {
    int countPairs(int arr[], int target) {
        int n = arr.length;
        int i = 0, j = n - 1;
        int count = 0;

        while (i < j) {
            int sum = arr[i] + arr[j];
            if (sum < target) {
                i++;
            } else if (sum > target) {
                j--;
            } else { // sum == target
                int el1 = arr[i], el2 = arr[j], count1 = 0, count2 = 0;

                // Count occurrences of el1
                while (i <= j && arr[i] == el1) {
                    i++;
                    count1++;
                }

                // Count occurrences of el2
                while (j >= i && arr[j] == el2) {
                    j--;
                    count2++;
                }

                // Count pairs
                if (el1 == el2) {
                    count += (count1 * (count1 - 1)) / 2; // nC2
                } else {
                    count += (count1 * count2);
                }
            }
        }
        return count;
    }
}
