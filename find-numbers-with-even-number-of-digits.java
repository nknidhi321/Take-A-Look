// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/

Intuition :-
---------
Only numbers between 10 and 99 or 1000 and 9999 or 100000 have even number of digits.
Taking advantage of constraints nums[i] <= 10^5

```
class Solution {
 
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i : nums) {
            if ((i >= 10 && i <= 99) || (i >= 1000 && i <= 9999) || (i == 100000)) {
                count++;
            }
        }       
        return count;
    }
}
```
--------------------------------------------------------------------------------------
