// Version 1 - Brute Force
// Idea: Compare every element with every later element to detect any duplicate.
// Time: O(n²)
// Space: O(1)
class Solution {
    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }
}

// Version 2 — Sorting + Scan
// Idea: Sort the array so equal values become adjacent, then scan neighbors.
// Time: O(n log n)
// Space: O(1)

class Solution {

    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }

        return false;
    }
}
// Version 3 — HashSet (Optimal)
// Idea: Store numbers as we scan; if a number already exists, it is a duplicate.
// Time: O(n) expected
// Space: O(n)
import java.util.HashSet;

class Solution {

    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        HashSet<Integer> seen = new HashSet<>();

        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }
}