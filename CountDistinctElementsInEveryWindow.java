class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        //Optimal TC - O(n) SC - O(k)
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (i >= k) {
                int value = arr[j];
                if (map.get(value) > 1) {
                    map.put(value, map.get(value) - 1);
                } else {
                    map.remove(value);
                }
                j++;
            }
            if (i >= k - 1) {
                ans.add(map.size());
            }
        }
        return ans;
        
        // //Bruteforce TC - O(n*K) SC - O(K)
        // int n=arr.length;
        // ArrayList<Integer> ans=new ArrayList<>();
        // for(int i=0;i<=n-k;i++){
        //     HashSet<Integer> set=new HashSet<>();
        //     for(int j=i;j<i+k;j++){
        //         set.add(arr[j]);
        //     }
        //     ans.add(set.size());
        // }
        // return ans;
    }
}