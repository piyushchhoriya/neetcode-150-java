// Two Sum:
// Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// You can return the answer in any order.

// Example 1:

// Input: nums = [2,7,11,15], target = 9
// Output: [0,1]
// Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

// Brute Force: Using 2 loops
// Time Complexity : O(n^2)
// Space Complexity : O(1)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int n = nums.length;
        for(int i=0;i<n;i++){
            int complement = target - nums[i];
            for(int j=i+1;j<n;j++){
                if(nums[j] == complement){
                    return new int[]{i,j};
                }
            } 
        }
        return new int[]{-1,-1};
    }
}

// Optimal : Using hashmap
// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }

}