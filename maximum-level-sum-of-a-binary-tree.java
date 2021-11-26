//https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/

// DFS // Take-A-Look

class Solution {
    public int maxLevelSum(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        
        //NOTE : Assuming first Level is 0
        dfs(root, 0, list);
        
        //Finding maxSumLevel from all the level sum we got in list
        int maxSumLevel = -1;
        int maxSum = Integer.MIN_VALUE;
        for(int level = 0; level < list.size(); level++) {
            int currLevelSum = list.get(level); 
            if(currLevelSum > maxSum) {
                maxSum = currLevelSum;
                maxSumLevel = level;
            } 
        }
        return maxSumLevel + 1; //In question level starts from 1, so +1
    }  
    
    public static void dfs(TreeNode root, int level, ArrayList<Integer> list) {
        if(root == null) return;
        
        // Reached to ith level and size of list is also i, say 0th level pe hai aur list ka size v 0 hai.
        // So the current root will be the 1st value to be added of that level in the list.
        if(list.size() == level) list.add(root.val);
        
        // Reached to a level where size > level of the list, then some nodes sum of that level already exists,
        // So add curr node sum in the existing sum of that level, and replace at that list index only.
        else list.set(level, list.get(level) + root.val);
        
        dfs(root.left, level + 1, list);
        dfs(root.right, level + 1, list);
    }
}

//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX

// BFS 

class Solution {
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        
        int maxSumLevel = -1;
        int maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int level = 1;
        while(!queue.isEmpty()) {
            int currLevelSum = 0;
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                currLevelSum += node.val;
                
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(currLevelSum > maxSum) {
                maxSum = currLevelSum;
                maxSumLevel = level;
            } 
            level++;
        }
        return maxSumLevel;
    }
}
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
