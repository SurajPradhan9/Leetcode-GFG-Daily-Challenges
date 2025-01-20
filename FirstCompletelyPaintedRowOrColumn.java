class Solution {
    // 1. Brute force approach without count arrays: Traverse row and column for each element in arr
    public int firstCompleteIndexBruteForce(int[] arr, int[][] mat) {
        int m = mat.length;      // Number of rows
        int n = mat[0].length;   // Number of columns

        // Create a HashMap to store the positions (row, col) of elements
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        // Traverse each element in the arr
        for (int i = 0; i < arr.length; i++) {
            int[] cell = map.get(arr[i]);
            int row = cell[0];
            int col = cell[1];
            
            // Mark the element by setting it to a negative value
            mat[row][col] = -mat[row][col];

            // Check if the entire row is marked
            boolean rowComplete = true;
            for (int j = 0; j < n; j++) {
                if (mat[row][j] > 0) {  // If any element in the row is positive, it's not marked
                    rowComplete = false;
                    break;
                }
            }

            // Check if the entire column is marked
            boolean colComplete = true;
            for (int j = 0; j < m; j++) {
                if (mat[j][col] > 0) {  // If any element in the column is positive, it's not marked
                    colComplete = false;
                    break;
                }
            }

            // If either the row or column is completed, return the current index
            if (rowComplete || colComplete) {
                return i;
            }
        }
        
        return -1;  // If no row or column is completed
    }

    // 2. Optimized approach with count arrays (rowCount and colCount)
    public int firstCompleteIndexOptimizedWithCountArrays(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int[] cell = map.get(arr[i]);
            int row = cell[0];
            int col = cell[1];
            rowCount[row]++;
            colCount[col]++;
            if (rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }
        return -1;
    }

    // 3. Optimized approach with Pair class (same as optimized with count arrays, just using Pair for row/column storage)
    class Pair {
        int row;
        int col;
        Pair(int i, int j) {
            this.row = i;
            this.col = j;
        }
    }

    public int firstCompleteIndexWithPair(int[] arr, int[][] mat) {
        HashMap<Integer, Pair> map = new HashMap<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat[i][j], new Pair(i, j));
            }
        }

        int[] rowCount = new int[m];
        int[] colCount = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int row = map.get(arr[i]).row;
            int col = map.get(arr[i]).col;
            rowCount[row]++;
            colCount[col]++;
            if (rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }
        return -1;
    }
}
