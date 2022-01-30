// https://leetcode.com/problems/sort-the-matrix-diagonally/

/*
    Intuition :
    ---------
    Iterate diagonally over all the elements, store the values in list, sort it and place it back.
*/

```
class Solution {
    
    public int[][] diagonalSort(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Main dia + Lower gap
        for(int gap = 0; gap < n; gap++) {
            List<Integer> list = new ArrayList<>();
            for(int i = gap, j = 0; i < n && j < m; i++, j++) list.add(mat[i][j]);          // Travsersing diagonally and adding elements in list
            Collections.sort(list);                                                         // Sort kar diye list ko
            int idx = 0;
            for(int i = gap, j = 0; i < n && j < m; i++, j++) mat[i][j] = list.get(idx++);  // Travel on same dia and sorted elements ko wapas daal do
        }
        
        // Upper dia
        for(int gap = 1; gap < m; gap++) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0, j = gap; i < n && j < m; i++, j++) list.add(mat[i][j]);          // Travsersing diagonally and adding elements in list
            Collections.sort(list);                                                         // Sort kar diye list ko
            int idx = 0;
            for(int i = 0, j = gap; i < n && j < m; i++, j++) mat[i][j] = list.get(idx++);  // Travel on same dia and sorted elements ko wapas daal do
        }
        
        return mat;
    }
}
```
----------------------------------------------------------------------------------------------------------------------------------------------------
