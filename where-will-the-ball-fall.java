// https://leetcode.com/problems/where-will-the-ball-fall/

```
class Solution {
    
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];
        
        for(int ball = 0; ball < m; ball++) { // Sare balls k liye check karo *
            int i = 0, j = ball;
            
            // * ki kya wo n tak pahuch paaya ?
            while(i != n) { // Note : n - 1 pe answer nahi bnega
                
                /*  Invalid case :-
                    1) First column me agar / mil gaya toh fas jaaoge
                    2) Last column me agar \ mil gaya toh fas jaaoge
                */
                if((j == 0 && grid[i][j] == -1) || (j == m - 1 && grid[i][j] == 1)) {
                    ans[ball] = -1; // Fas gaye
                    break;
                }
                
                /*
                    Agar \\ hai mai aur mere next wala cell, toh he age badh paaenge
                */
                else if(grid[i][j] == 1 && grid[i][j + 1] == 1) {
                    i++; j++; // Move to right diagonally
                }
                
                /*
                    Agar // hai mai aur mere previous wala cell toh he aage badh paaenge
                */
                else if(grid[i][j] == -1 && grid[i][j - 1] == -1) {
                    i++; j--; // Move to left diagonally
                }
                
                /*
                    Invalid case :-
                    1) \/  shape
                    2) /\ shape
                */
                else { 
                    ans[ball] = -1; // Fas gaye
                    break; 
                }
            }
            if(i == n) ans[ball] = j;
        }
        return ans;
    }
}
```
-----------------------------------------------------------------------------------------------------------------

// Same code without comments

```
class Solution {
    
    public int[] findBall(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] ans = new int[m];
        
        for(int ball = 0; ball < m; ball++) {
            int i = 0, j = ball;
            while(i != n) {
                if((j == 0 && grid[i][j] == -1) || (j == m - 1 && grid[i][j] == 1)) {ans[ball] = -1; break;}
                else if(grid[i][j] == 1 && grid[i][j + 1] == 1) {i++; j++;}
                else if(grid[i][j] == -1 && grid[i][j - 1] == -1) {i++; j--;}
                else {ans[ball] = -1; break;}
            }
            if(i == n) ans[ball] = j;
        }
        return ans;
    }
}
```
------------------------------------------------------------------------------------------------------------------
