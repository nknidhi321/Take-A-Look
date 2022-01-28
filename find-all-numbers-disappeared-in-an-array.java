// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

Intuition :-
---------
Array pe iterate karo, Jo v val mil rahe h, usi array me us val ko as an idx treat karo aur us idx pe jo v number rakha ho use -(number) kar k aa jaao 
[Note final -(number) he hona chahiye wo] => wo wala val hame mil chuka hai, and aise krte krte jo v val last me +ve bach gaya wo hamara answers hai.
Doing so to do in  O(1) space and O(2N) pass

```
class Solution {
    
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        
        // 4 3 -2 -7 8 2 3 1
        for(int i = 0; i < n; i++) {    
            int val = Math.abs(nums[i]) - 1;
            if(nums[val] > 0) {
                nums[val] = -1 * nums[val];
            }
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            if(nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
```
-------------------------------------------------------------
