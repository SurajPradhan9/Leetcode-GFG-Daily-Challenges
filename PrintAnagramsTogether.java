class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        int n = arr.length;
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            // Convert the current string to a character array
            char[] temp = arr[i].toCharArray();
            
            // Sort the character array
            Arrays.sort(temp);
            
            // Convert the sorted array back to a string (this is the key)
            String sortedKey = new String(temp);
            
            // If the key is not present in the map, initialize a new list
            if (!map.containsKey(sortedKey)) {
                map.put(sortedKey, new ArrayList<>());
            }
            
            // Add the original string to the list corresponding to the key
            map.get(sortedKey).add(arr[i]);
        }
        
        // Add all groups of anagrams to the result list
        ans.addAll(map.values());
        
        return ans;
    }
}
